package com.example.myfamilyhandbook.addNewNote

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfamilyhandbook.manager.NotesManager
import com.example.myfamilyhandbook.databinding.ActivityAddNewNoteBinding
import com.example.myfamilyhandbook.main.MainActivity

class AddNewNoteActivity : AppCompatActivity() {

    private val binding: ActivityAddNewNoteBinding by lazy {
        ActivityAddNewNoteBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        saveButton()
    }

    private fun saveButton() {
        val name = binding.nameEditText.text
        val age = binding.ageEditText.text

        binding.saveButton.setOnClickListener {
            NotesManager.addNote(name.toString(), age.toString().toInt())
            returnToActivity()
        }
    }

    private fun returnToActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}



