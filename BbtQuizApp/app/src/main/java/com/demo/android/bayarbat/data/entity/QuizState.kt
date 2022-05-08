package com.demo.android.bayarbat.data.entity

sealed class QuizState {

    object LoadingState : QuizState()
    data class DataState(val data: QuestionAndAllAnswers): QuizState()
    object EmptyState : QuizState()
    data class FinishState(val numberOfQuestions: Int, val score: Int, val skipped: Int, val resultDetail: String) : QuizState()

}