package com.example.classlistapp

object DataManager {
    val students = mutableListOf<Student>()

    init {
        createMockData()
    }

    fun createMockData() {
        students.add(Student("David", "Au20", true))
        students.add(Student("Lois", "Au20"))
        students.add(Student("Laura", "Au20"))
        students.add(Student("Susan", "Au20"))
        students.add(Student("Jacob", "Au20"))
        students.add(Student("Per", "Au20"))
        students.add(Student("Elisabet", "Au20", true))
    }
}