package com.demo.android.bayarbat.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.demo.android.bayarbat.R
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result_details.*

class ResultDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_details)

        val resultDetails = intent.extras?.getString("RESULT_DETAIL")
        detailTextView.text = resultDetails
    }

    fun backToHome(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}