package com.example.myfamilyhandbook.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfamilyhandbook.manager.NotesManager
import com.example.myfamilyhandbook.manager.Note

class MainViewModel : ViewModel() {

    private val manager = NotesManager

    private val _notes = MutableLiveData(listOf<Note>())
    val notes: LiveData<List<Note>> = _notes

    init {
        getInitialNotes()
    }

    private fun getInitialNotes() {
        _notes.value = getNotes()
    }

    fun updateNotes() {
        _notes.value = getNotes()
    }

    private fun getNotes() = manager.getNotes()
}
