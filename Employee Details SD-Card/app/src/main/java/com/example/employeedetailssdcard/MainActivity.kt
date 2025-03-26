package com.example.employeedetailssdcard

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
        val etEmpid = findViewById<EditText>(R.id.edEmpId)
        val etName = findViewById<EditText>(R.id.edName)
        val etSal = findViewById<EditText>(R.id.edSalary)
        val btSave = findViewById<Button>(R.id.btSave)
        val btLoad = findViewById<Button>(R.id.btLoad)

        btSave.setOnClickListener {
            val empid = etEmpid.text.toString()
            val name = etName.text.toString()
            val sal = etSal.text.toString()

            val file = File(getExternalFilesDir(null), "emp.txt")
            val writer = FileWriter(file)
            writer.write("$empid\n$name\n$sal")
            writer.close()

            Toast.makeText(this,"Saved Successfully",Toast.LENGTH_LONG).show()
        }

        btLoad.setOnClickListener{

            val file = File(getExternalFilesDir(null),"emp.txt")
            val reader = BufferedReader(FileReader(file))
            val empid = reader.readLine()
            val name = reader.readLine()
            val sal = reader.readLine()
            etEmpid.setText(empid)
            etName.setText(name)
            etSal.setText(sal)

            reader.close()
        }

    }
}