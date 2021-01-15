package com.anup.week6.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anup.week6.R
import com.anup.week6.Storage
import com.anup.week6.fragments.HomeFragment
import com.anup.week6.model.Student
import com.bumptech.glide.Glide

class StudentAdapter(
        val lstStudents: ArrayList<Student>,
        val context: HomeFragment
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    private var storage = Storage()

    class StudentViewHolder(view: View):
            RecyclerView.ViewHolder(view){

                val tvName : TextView
                val tvAge : TextView
                val tvAddress : TextView
                val tvGender: TextView
                val imageView : ImageView
                val ivDelete : ImageView

                init {


                    tvName= view.findViewById(R.id.tvName)
                    tvAge= view.findViewById(R.id.tvAge)
                    tvAddress= view.findViewById(R.id.tvAddress)
                    tvGender= view.findViewById(R.id.tvGender)
                    imageView= view.findViewById(R.id.imageView)
                    ivDelete= view.findViewById(R.id.ivDelete)

                }


            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudents[position]

        holder.tvName.text = student.fullName
        holder.tvAge.text = student.age.toString()
        holder.tvAddress.text= student.address

        holder.tvGender.text = student.gender
        holder.ivDelete.setOnClickListener {
            storage.deleteStudent(student)
            notifyItemRemoved(position)
        }

        Glide.with(context)
            .load(student.ImageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return lstStudents.size
    }
}