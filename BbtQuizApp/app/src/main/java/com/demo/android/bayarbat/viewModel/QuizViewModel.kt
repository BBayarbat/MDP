package com.demo.android.bayarbat.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.android.bayarbat.data.QuizRepository
import com.demo.android.bayarbat.data.entity.QuestionAndAllAnswers
import com.demo.android.bayarbat.data.entity.QuizState
import java.lang.StringBuilder

class QuizViewModel(repository: QuizRepository): ViewModel() {

    private val questionAndAnswers = MediatorLiveData<QuestionAndAllAnswers>()
    private val currentQuestion = MutableLiveData<Int>()
    private val currentState = MediatorLiveData<QuizState>()
    private val allQuestionAndAllAnswers = repository.getQuestionAndAllAnswers()
    private var score: Int = 0
    private var skipped: Int = 0
    private var resultDetail: StringBuilder = StringBuilder()

    init {
        currentState.postValue(QuizState.LoadingState)
        addStateSources()
        addQuestionSources()
        currentQuestion.postValue(0)
    }


    fun getCurrentState(): LiveData<QuizState> = currentState

    private fun changeCurrentQuestion(){
        currentQuestion.postValue(currentQuestion.value?.inc())
    }

    fun addStateSources(){

        currentState.addSource(currentQuestion){
                currentQuestionNumber ->
            if (currentQuestionNumber == allQuestionAndAllAnswers.value?.size){
                currentState.postValue(QuizState.FinishState(currentQuestionNumber, score, skipped, resultDetail.toString()))
            }
        }

        currentState.addSource(allQuestionAndAllAnswers){
                allQuestionAndAnswers ->
            if (allQuestionAndAnswers.isEmpty()){
                currentState.postValue(QuizState.EmptyState)
            }
        }

        currentState.addSource(questionAndAnswers){
                questionAndAnswers ->
            currentState.postValue(QuizState.DataState(questionAndAnswers))
        }

    }

    private fun addQuestionSources(){

        questionAndAnswers.addSource(currentQuestion){
                currentQuestionNumber ->
            val questions = allQuestionAndAllAnswers.value
            if (questions != null && currentQuestionNumber < questions.size){
                questionAndAnswers.postValue(questions[currentQuestionNumber])
            }
        }

        questionAndAnswers.addSource(allQuestionAndAllAnswers){
                questionsAndAnswers ->
            val currentQuestionNumber = currentQuestion.value
            if (currentQuestionNumber != null && questionsAndAnswers.isNotEmpty()){
                questionAndAnswers.postValue(questionsAndAnswers[currentQuestionNumber])
            }
        }

    }

    fun nextQuestion(choice: Int){
        verifyAnswer(choice)
        changeCurrentQuestion()
    }

    private fun verifyAnswer(choice: Int) {
        val currentQuestion = questionAndAnswers.value

        if (currentQuestion != null) {
            if (currentQuestion.answers[choice].isCorrect){
                score++
            }

            if(!resultDetail.isEmpty()){
                resultDetail.append("\n\n")
            }
            resultDetail.append(currentQuestion.question?.text ?: "")
            resultDetail.append("\nYour answer: " + currentQuestion.answers[choice].text)
            resultDetail.append("\nCorrect answer: " + currentQuestion.answers[choice].text)
        }
    }

    fun skipQuestion(){
        skipped++
        changeCurrentQuestion()
    }
}