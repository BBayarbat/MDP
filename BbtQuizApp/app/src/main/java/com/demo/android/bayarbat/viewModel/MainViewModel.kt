package com.demo.android.bayarbat.viewModel

import androidx.lifecycle.ViewModel
import com.demo.android.bayarbat.data.QuestionAndAnswerListProvider
import com.demo.android.bayarbat.data.QuizRepository

class MainViewModel(private val repository: QuizRepository): ViewModel() {

    private lateinit var  questionAndAnswerListProvider: QuestionAndAnswerListProvider

    fun prepopulateQuestions(){
        questionAndAnswerListProvider = QuestionAndAnswerListProvider()
        for (question in questionAndAnswerListProvider.questionList){
            repository.saveQuestion(question)
        }
        for (answer in questionAndAnswerListProvider.answerList){
            repository.saveAnswer(answer)
        }
    }

    fun clearQuestions() = repository.deleteQuestions()

}