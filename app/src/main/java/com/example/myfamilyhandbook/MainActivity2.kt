package com.example.myfamilyhandbook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfamilyhandbook.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var bindingClass2: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindingClass2.root)
        saveButton()

    }

    fun saveButton() {
        val name =   bindingClass2.nameEditText.text
        val age =  bindingClass2.ageEditText.text

        bindingClass2.Savebutton.setOnClickListener {
            NotesManager.addNote(name.toString(), age.toString().toInt())
            returnToActivity()

        }

    }
        fun returnToActivity() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }



