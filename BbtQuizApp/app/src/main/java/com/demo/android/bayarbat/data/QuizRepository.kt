package com.demo.android.bayarbat.data

import androidx.lifecycle.LiveData
import com.demo.android.bayarbat.data.entity.Answer
import com.demo.android.bayarbat.data.entity.Question
import com.demo.android.bayarbat.data.entity.QuestionAndAllAnswers

interface QuizRepository {
    fun getSavedQuestions(): LiveData<List<Question>>

    fun saveQuestion(question: Question)

    fun saveAnswer(answer: Answer)

    fun getQuestionAndAllAnswers(): LiveData<List<QuestionAndAllAnswers>>

    fun deleteQuestions()
}