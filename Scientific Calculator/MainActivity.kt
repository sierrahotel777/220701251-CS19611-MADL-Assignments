package com.example.scientificcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var display: EditText
    private var currentExpression: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val buttons = listOf(R.id.btnSin, R.id.btnCos, R.id.btnTan, R.id.btnSqrt, R.id.btnLog, R.id.btnPow,
            R.id.btnMod, R.id.btnDiv, R.id.btnMul, R.id.btnSub, R.id.btnAdd, R.id.btnEqual)

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener { handleInput(it as Button) }
        }
    }

    private fun handleInput(button: Button) {
        val buttonText = button.text.toString()

        when (buttonText) {
            "sin" -> calculateUnary(::sin)
            "cos" -> calculateUnary(::cos)
            "tan" -> calculateUnary(::tan)
            "√" -> calculateUnary(::sqrt)
            "log" -> calculateUnary(::log10)
            "x^y" -> appendToExpression("^")
            "%" -> appendToExpression("%")
            "/", "*", "-", "+" -> appendToExpression(buttonText)
            "=" -> calculateResult()
            else -> appendToExpression(buttonText)
        }
    }

    private fun appendToExpression(value: String) {
        currentExpression += value
        display.setText(currentExpression)
    }

    private fun calculateUnary(function: (Double) -> Double) {
        try {
            val result = function(currentExpression.toDouble())
            display.setText(result.toString())
            currentExpression = result.toString()
        } catch (e: Exception) {
            display.setText("Error")
        }
    }

    private fun calculateResult() {
        try {
            val sanitizedExpression = currentExpression.replace("^", "**")
            val result = evaluateExpression(sanitizedExpression)
            display.setText(result.toString())
            currentExpression = result.toString()
        } catch (e: Exception) {
            display.setText("Error")
        }
    }

    private fun evaluateExpression(expression: String): Double {
        return when {
            expression.contains("+") -> {
                val parts = expression.split("+")
                parts[0].toDouble() + parts[1].toDouble()
            }
            expression.contains("-") -> {
                val parts = expression.split("-")
                parts[0].toDouble() - parts[1].toDouble()
            }
            expression.contains("*") -> {
                val parts = expression.split("*")
                parts[0].toDouble() * parts[1].toDouble()
            }
            expression.contains("/") -> {
                val parts = expression.split("/")
                parts[0].toDouble() / parts[1].toDouble()
            }
            expression.contains("%") -> {
                val parts = expression.split("%")
                parts[0].toDouble() % parts[1].toDouble()
            }
            expression.contains("^") -> {
                val parts = expression.split("^")
                parts[0].toDouble().pow(parts[1].toDouble())
            }
            else -> expression.toDouble()
        }
    }
}
