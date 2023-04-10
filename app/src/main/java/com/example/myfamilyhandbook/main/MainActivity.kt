package com.example.myfamilyhandbook.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfamilyhandbook.addNewNote.AddNewNoteActivity
import com.example.myfamilyhandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    private val adapter = NoteAdapter()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        subscribeToObservers()
        init()
        with(binding) {
            swipeRefreshLayout.setOnRefreshListener {
                viewModel.updateNotes()
                binding.swipeRefreshLayout.isRefreshing = false
            }
            addNoteButton.setOnClickListener {
                moveToAddNote()
            }
        }
    }

    private fun init() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(this@MainActivity)
        rcView.adapter = adapter
    }

    private fun subscribeToObservers() {
        viewModel.notes.observe(this) {
            adapter.updateNotes(it)
        }
    }

    private fun moveToAddNote() {
        val intent = Intent(this, AddNewNoteActivity::class.java)
        startActivity(intent)
    }

}




