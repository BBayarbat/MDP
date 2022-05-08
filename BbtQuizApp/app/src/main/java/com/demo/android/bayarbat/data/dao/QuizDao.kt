package com.demo.android.bayarbat.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.demo.android.bayarbat.data.entity.Answer
import com.demo.android.bayarbat.data.entity.Question
import com.demo.android.bayarbat.data.entity.QuestionAndAllAnswers

@Dao
interface QuizDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(question: Question)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(answer: Answer)

    @Query("DELETE FROM questions")
    fun clearQuestions()

    @Delete
    fun deleteQuestion(question: Question)

    @Query("SELECT * FROM questions ORDER BY question_id")
    fun getAllQuestions(): LiveData<List<Question>>

    @Transaction
    @Query("SELECT * FROM questions")
    fun getQuestionAndAllAnswers(): LiveData<List<QuestionAndAllAnswers>>
}