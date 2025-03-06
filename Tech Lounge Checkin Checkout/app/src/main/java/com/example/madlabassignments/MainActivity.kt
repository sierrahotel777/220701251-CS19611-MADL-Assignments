package com.example.madlabassignments

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var studentCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countText = findViewById<TextView>(R.id.studentCount)
        val checkInButton = findViewById<Button>(R.id.btnCheckIn)
        val checkOutButton = findViewById<Button>(R.id.btnCheckOut)

        checkInButton.setOnClickListener {
            studentCount++
            countText.text = studentCount.toString()
        }

        checkOutButton.setOnClickListener {
            if (studentCount > 0) {
                studentCount--
                countText.text = studentCount.toString()
            }
        }
    }
}