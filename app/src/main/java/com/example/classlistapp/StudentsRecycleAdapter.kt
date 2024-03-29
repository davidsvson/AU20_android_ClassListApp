package com.example.classlistapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class StudentsRecycleAdapter(val context: Context, val students : List<Student>) :
        RecyclerView.Adapter<StudentsRecycleAdapter.ViewHolder>(){

    val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = layoutInflater.inflate(R.layout.list_item , parent, false)

       return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]

        holder.textName.text = student.name
        holder.textClassName.text = student.className
        holder.presentButton.isChecked = student.present
        holder.studentPosition = position
    }

    override fun getItemCount() = students.size

    fun removeStudent(position: Int) {
        DataManager.students.removeAt(position)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {
        val textName = itemView.findViewById<TextView>(R.id.nameTextView)
        val textClassName = itemView.findViewById<TextView>(R.id.classTextView)
        val presentButton = itemView.findViewById<CheckBox>(R.id.checkBox)
        val deleteButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        var studentPosition = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, CreateAndEditStudentActivity::class.java)
                intent.putExtra(STUDENT_POSITION_KEY , studentPosition)
                context.startActivity(intent)
            }

            deleteButton.setOnClickListener {
                removeStudent(studentPosition)
            }

            presentButton.setOnClickListener {
                DataManager.students[studentPosition].present = presentButton.isChecked
                Toast.makeText(context, "${DataManager.students[studentPosition].name} presence is changed",
                Toast.LENGTH_SHORT).show()
            }

        }

    }
}