package com.example.rec_digitalcafeloginvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = findViewById<EditText>(R.id.emailid).text
        val pass = findViewById<EditText>(R.id.password).text
        val button = findViewById<Button>(R.id.validate)
        val passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#\$%^&+=!])(?=\\S+\$).{8,}\$"

        button.setOnClickListener {
            val emailid = email.toString().trim()
            val password = pass.toString().trim()
            if(emailid.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Username and Userid cannot be left empty",Toast.LENGTH_SHORT).show()
            }
            if (!emailid.endsWith("@rajalakshmi.edu.in")){
                Toast.makeText(this, "Email id is not valid", Toast.LENGTH_SHORT).show()
            }
            if (!(password.matches(passwordPattern.toRegex()))){
                Toast.makeText(this, "Password field should have alphabets, 1 numeric values and 1 special symbol (minimum 8-characters)", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            }
        }
    }
}