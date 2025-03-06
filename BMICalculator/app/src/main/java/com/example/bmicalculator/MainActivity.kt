package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.calculate)
        val weight = findViewById<EditText>(R.id.weight)
        val height = findViewById<EditText>(R.id.height)
        val bmi = findViewById<TextView>(R.id.bmi)

        button.setOnClickListener {
            val wt = weight.text.toString()
            val ht = height.text.toString()
            val bmiid = ((wt.toFloat() / (ht.toFloat() * ht.toFloat()))*10000)
            if (bmiid< 18.5){
                bmi.text = "Underweight"
            }
            else if (bmiid in 18.5..24.9){
                bmi.text = "Normal"
            }
            else if (bmiid in 25.0..29.9){
                bmi.text = "Overweight"
            }
            else if (bmiid >=30){
                bmi.text = "Obese"
            }
        }
    }
}