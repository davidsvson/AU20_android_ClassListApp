package com.example.classlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val STUDENT_POSITION_KEY = "STUDENT_POSITION"


class CreateAndEditStudentActivity : AppCompatActivity() {

    lateinit var nameEditText: EditText
    lateinit var classEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_and_edit_student)

        nameEditText = findViewById(R.id.nameEditText)
        classEditText = findViewById(R.id.classEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val studentPosition =  intent.getIntExtra(STUDENT_POSITION_KEY, 0)

        displayStudent(studentPosition)

        saveButton.setOnClickListener {
            editStudent(studentPosition)
        }


        // editStudent(studentPosition)

    }

    fun displayStudent(position : Int) {
        val student = DataManager.students[position]

        nameEditText.setText(student.name)
        classEditText.setText(student.className)

    }


    fun editStudent(position: Int) {
        DataManager.students[position].name = nameEditText.text.toString()
        DataManager.students[position].className = classEditText.text.toString()

        finish()
    }

}