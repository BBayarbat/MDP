package com.miu.resume

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class ResumeActivity : AppCompatActivity() {
    private lateinit var resumeItemsAdapter: ResumeItemsAdapter
    private lateinit var indicatorContainer: LinearLayout
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)

        preferences = applicationContext.getSharedPreferences("RESUME", Context.MODE_PRIVATE)

        setResumeItems()
        setupIndicators()
        setCurrentIndicator(0)
    }

    private fun setResumeItems(){
        resumeItemsAdapter = ResumeItemsAdapter(
            listOf(
                ResumeItem(
                    resumeImage = R.drawable.img_home,
                    title = "Bayarbat Batbayar",
                    description = "I'm a software engineer, Accomplished Software Developer with more than 10 years of professional experience meeting customer needs and requirements while implementing latest techniques during all phases of software development life cycle. Keen Analyst who researches and analyzes solution efficiency, cost effectiveness, and financial feasibility of projects."
                ),
                ResumeItem(
                    resumeImage = R.drawable.img_education,
                    title = "Maharishi International University",
                    description = "Started for a Master degree in Computer science at MIU in Feb 2021. Studied Modern Programming Practices, Software Engineering, Enterprise Architecture and Advanced Software Development courses."
                ),
                ResumeItem(
                    resumeImage = R.drawable.img_john_deere,
                    title = "John Deere via Volt Corp",
                    description = "I have been working in the ISG team at John Deere as Software engineer since Oct 2021. The client company is John Deere. The company manufactures agricultural machinery,\n" +
                            "heavy equipment, forestry machinery, diesel engines, drivetrains (axles, transmissions,\n" +
                            "gearboxes) used in heavy equipment, and lawn care equipment. In 2019, it was listed as\n" +
                            "87th in the Fortune five hundred America's ranking. I have joined the IT department"
                ),
                ResumeItem(
                    resumeImage = R.drawable.img_grapecity,
                    title = "Grapecity Mongolia",
                    description = "I have worked at Grapecity Mongolia company as Senior Software engineer between 2007 and 2021."
                ),
                ResumeItem(
                    resumeImage = R.drawable.img_about_me,
                    title = "Bayarbat Batbayar",
                    description = "Accomplished software engineering professional with over 10 years of hands-on experience in full development lifecycle within banking and payment systems using Java Technologies."
                ),
                ResumeItem(
                    resumeImage = R.drawable.img_contact1,
                    title = "Bayarbat Batbayar",
                    description = "Email: bbatbayar@miu.edu\n" + "Mobile: 1 641-819-1522\n" + "LinkedIn: LinkedIn.com"
                )
            )
        )
        val resumeViewPager = findViewById<ViewPager2>(R.id.resumeViewPager)
        resumeViewPager.adapter = resumeItemsAdapter
        resumeViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (resumeViewPager.getChildAt(0) as RecyclerView). overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
        findViewById<MaterialButton>(R.id.buttonNext).setOnClickListener{
            if (resumeViewPager.currentItem+1 < resumeItemsAdapter.itemCount){
                resumeViewPager.currentItem += 1
            } else {
                navigateToHomeActivity()
                setCompleteResume()
            }
        }
    }

    private fun navigateToHomeActivity() {
        startActivity(Intent(applicationContext,MainActivity::class.java))
        finish()
    }

    private fun setCompleteResume() {
        preferences.edit().putBoolean("ISCOMPLETE", true).apply()
    }

    private fun setupIndicators(){
        indicatorContainer = findViewById(R.id.indicatorsContainer)
        val indicators = arrayOfNulls<ImageView>(resumeItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT )
        layoutParams.setMargins(8,0,8,0,)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorContainer.addView(it)
            }
        }
    }
    private fun setCurrentIndicator (position: Int){
        val childCount = indicatorContainer.childCount
        for( i  in 0 until childCount){
            val imageView = indicatorContainer.getChildAt(i) as ImageView
            imageView.scaleType = ImageView.ScaleType.FIT_END
            val layoutParams: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT )
            imageView.layoutParams = layoutParams
            if(i == position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_backgound
                    )
                )
            }
        }
    }
}