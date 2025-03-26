package com.example.bookdetailssdcard

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etAuthor = findViewById<EditText>(R.id.etAuthor)
        val etPublisher = findViewById<EditText>(R.id.etPublisher)
        val etPrice = findViewById<EditText>(R.id.etPrice)
        val btSave = findViewById<Button>(R.id.btSave)
        val btLoad = findViewById<Button>(R.id.btLoad)

        btSave.setOnClickListener {
            val title = etTitle.text.toString()
            val author = etAuthor.text.toString()
            val publisher = etPublisher.text.toString()
            val price = etPrice.text.toString()

            val file = File(getExternalFilesDir(null), "books.txt")
            val writer = FileWriter(file)
            writer.write("$title\n$author\n$publisher\n$price")
            writer.close()

            Toast.makeText(this,"Saved Successfully",Toast.LENGTH_LONG).show()
        }

        btLoad.setOnClickListener{

            val file = File(getExternalFilesDir(null),"books.txt")
            val reader = BufferedReader(FileReader(file))
            val title = reader.readLine()
            val author = reader.readLine()
            val publisher= reader.readLine()
            val price= reader.readLine()

            etTitle.setText(title)
            etAuthor.setText(author)
            etPublisher.setText(publisher)
            etPrice.setText(price)

            reader.close()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}