package com.example.myfamilyhandbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfamilyhandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val notes = NotesManager.getNotes()
    val adapter = NoteAdapter(notes)

    private val bindingClass: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)
        init()
        bindingClass.AddNoteButton.setOnClickListener {
            showAddNoteDialog()
        }
        refreshApp()
    }
        fun init() {
            bindingClass.rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            bindingClass.rcView.adapter = adapter
        }
    private fun refreshApp() {
        bindingClass.SwipeRefreshlayout.setOnRefreshListener {
            bindingClass.SwipeRefreshlayout.isRefreshing = false
        }

    }



    private fun showAddNoteDialog() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

}




