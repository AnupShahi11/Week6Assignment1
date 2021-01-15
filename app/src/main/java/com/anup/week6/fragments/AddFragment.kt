package com.anup.week6.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.anup.week6.R
import com.anup.week6.Storage
import com.anup.week6.model.Student


class AddFragment : Fragment() {
    private lateinit var etName : EditText
    private lateinit var etAge : EditText
    private lateinit var etAddress : EditText
    private lateinit var etImageURL : EditText
    private lateinit var btnSave : Button
    private lateinit var rbMale : RadioButton
    private lateinit var rbFemale : RadioButton
    private lateinit var rbOthers : RadioButton
    private var userImageURL =""
    var res : Boolean = true
    private var gender ="Not Selected"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        etName = view.findViewById(R.id.etName)
        etAge = view.findViewById(R.id.etAge)
        etAddress = view.findViewById(R.id.etAddress)
        etImageURL = view.findViewById(R.id.etImageURL)
        rbMale = view.findViewById(R.id.rbMale)
        rbFemale = view.findViewById(R.id.rbFemale)
        rbOthers = view.findViewById(R.id.rbOthers)
        btnSave = view.findViewById(R.id.btnSave)

        rbMale.setOnClickListener {
            gender = "Male"
        }
        rbFemale.setOnClickListener {
            gender = "Female"
        }

        rbOthers.setOnClickListener {
            gender = "Others"
        }

        btnSave.setOnClickListener {
           if (validateInput()) {
               var name = etName.text.toString()
               var age = etAge.text.toString()
               var address = etAddress.text.toString()
               userImageURL = etImageURL.text.toString()
               Storage().appendStudent(Student(name, userImageURL, age, address, gender))
               Toast.makeText(view?.context, "Student Added", Toast.LENGTH_SHORT).show()

               etName.setText("")
               etAge.setText("")
               etAddress.setText("")
               etImageURL.setText("")
           }
            else{
               Toast.makeText(view?.context, "Try Again", Toast.LENGTH_SHORT).show()
           }


        }

        return view


    }

    private fun validateInput(): Boolean {
        when {
            TextUtils.isEmpty(etName.text)-> {
                etName.error = "Field must not be empty"
                etName.requestFocus()
                res = false
            }

            TextUtils.isEmpty(etImageURL.text)-> {
                etImageURL.error = "Field must not be empty"
                etImageURL.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etAge.text)-> {
                etAge.error = "Field must not be empty"
                etAge.requestFocus()
                res = false
            }

            TextUtils.isEmpty(etAddress.text)-> {
                etAddress.error = "Field must not be empty"
                etAddress.requestFocus()
                res = false
            }

        }
        return res

    }
}