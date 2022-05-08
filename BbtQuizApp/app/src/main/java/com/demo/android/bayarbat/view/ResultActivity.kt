package com.demo.android.bayarbat.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.demo.android.bayarbat.R
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask

class ResultActivity : AppCompatActivity() {

    private var resultDetail: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.extras?.getInt("SCORE")
        val skipped = intent.extras?.getInt("SKIPPED")
        val numberOfQuestions = intent.extras?.getInt("NUMBER_OF_QUESTIONS")
        val wrong = intent.extras?.getInt("WRONG")
        resultDetail = intent.extras?.getString("RESULT_DETAIL").toString()

        scoreTextView.text =
            "Total Questions : " + numberOfQuestions + "\nSkipped questions: " + skipped + "\nRight answers: " + score + "\nWrong answers: " + wrong
    }

    fun startAgain(view: View) {
        startActivity(Intent(this, QuestionActivity::class.java))
    }

    fun resultDetail(view: View) {
        startActivity(
            intentFor<ResultDetailActivity>(
                "RESULT_DETAIL" to resultDetail
            ).newTask().clearTask()
        )
    }

    fun backToHome(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}