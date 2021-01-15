package com.anup.week6

import com.anup.week6.model.Student

private var listStudent = arrayListOf<Student>()
var loggedin : Student? =null

class Storage {
    fun appendStudent(student: Student){
        listStudent.add(student)
        println(listStudent.size)
    }

    fun returnStudent():ArrayList<Student>{
        return listStudent
    }

    fun deleteStudent(student: Student){
        listStudent.remove(student)
    }

    public fun setLoggedIn(id : Student?){
        println(id)
        loggedin = id
    }
    public fun getLoggedIn(): Student?{
        return loggedin
    }
}