package com.miu.tablelayout

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.setPadding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener {
            if (version.text.isEmpty() || name.text.isEmpty()) {
                Toast.makeText(applicationContext, "Enter android version or code name", Toast.LENGTH_LONG).show()
            } else {
                val tableRow = TableRow(applicationContext)
                val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
                tableRow.layoutParams = layoutParams

                val columnVersion = TextView(this)
                columnVersion.text = version.text.toString()
                columnVersion.setPadding(10)
                columnVersion.setBackgroundColor(Color.parseColor("#f368e0"))

                val columnCode = TextView(this)
                columnCode.text = name.text.toString()
                columnCode.setPadding(10)
                columnCode.setBackgroundColor(Color.parseColor("#f368e0"))

                tableRow.addView(columnVersion)
                tableRow.addView(columnCode)
                tableRow.setPadding(0, 0, 0, 10)

                table.addView(tableRow)

                // clear edit text
                version.text.clear()
                name.text.clear()

                Toast.makeText(applicationContext, "Added new row", Toast.LENGTH_LONG).show()
            }
        }
    }
}