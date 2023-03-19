package com.example.myfamilyhandbook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfamilyhandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val notes = NotesManager.getNotes()
    private val adapter = NoteAdapter(notes)
    private val bindingClass: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)
        init()
        bindingClass.addNoteButton.setOnClickListener {
            showAddNoteDialog()
        }
    }

    private fun init() = with(bindingClass) {
        rcView.layoutManager = LinearLayoutManager(this@MainActivity)
        rcView.adapter = adapter
    }

    private fun showAddNoteDialog() {
        val intent = Intent(this, AddNewNote::class.java)
        startActivity(intent)
    }

}




