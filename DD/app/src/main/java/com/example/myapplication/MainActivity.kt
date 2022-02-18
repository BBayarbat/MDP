package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var food = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickBtnAddFood(view: View) {

        if(!food.contains(txtFood.text.toString())){
            food.add(txtFood.text.toString())
        }

    }
    fun onClickBtnDecide(view: View) {
        val randomIndex = Random.nextInt(food.size)
        val randomElement = food[randomIndex]

        txtFood.setText(randomElement)
    }
}