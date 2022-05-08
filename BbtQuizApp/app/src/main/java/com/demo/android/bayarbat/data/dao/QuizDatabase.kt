package com.demo.android.bayarbat.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.android.bayarbat.data.entity.Answer
import com.demo.android.bayarbat.data.entity.Question

@Database(entities = [(Question::class), (Answer::class)], version = 1)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun quizDao(): QuizDao

}