package com.example.randomnumber

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val minValueInput = findViewById<EditText>(R.id.minValueInput)
        val maxValueInput = findViewById<EditText>(R.id.maxValueInput)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        generateButton.setOnClickListener {
            val minValueText = minValueInput.text.toString()
            val maxValueText = maxValueInput.text.toString()

            if (minValueText.isNotEmpty() && maxValueText.isNotEmpty()) {
                try {
                    val minValue = minValueText.toInt()
                    val maxValue = maxValueText.toInt()

                    if (minValue < maxValue) {
                        val randomNumber = Random.nextInt(minValue, maxValue + 1)

                        resultText.text = "Generated Number: $randomNumber"
                    } else {
                        Toast.makeText(this, "Minimum value must be less than maximum value", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter both minimum and maximum values", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
