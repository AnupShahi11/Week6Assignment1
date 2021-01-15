 package com.anup.week6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anup.week6.R
import com.anup.week6.Storage
import com.anup.week6.adapter.StudentAdapter

 class HomeFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private var storage = Storage()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        loadStudents()


        return view

    }

     private fun loadStudents(){
         val arr = storage.returnStudent()
         val adapter = StudentAdapter(arr,this)
         recyclerView.layoutManager = LinearLayoutManager(view?.context,LinearLayoutManager.VERTICAL,false)
         recyclerView.adapter = adapter

     }


}