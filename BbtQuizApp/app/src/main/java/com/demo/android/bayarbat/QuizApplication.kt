package com.demo.android.bayarbat

import android.app.Application
import androidx.room.Room
import com.demo.android.bayarbat.data.dao.QuizDatabase

class QuizApplication : Application() {

    companion object{
        lateinit var database: QuizDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, QuizDatabase::class.java,
            "quiz_database").createFromAsset("database/quiz_database.db").build()
    }

}