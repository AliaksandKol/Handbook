package com.example.myfamilyhandbook.manager


object NotesManager {
    private val notes = mutableListOf<Note>()

    fun addNote(name: String, age: Int) {
        val id = if (notes.isEmpty()) {
            1
        } else {
            notes.last().id + 1
        }

        notes.add(Note(id, name, age))
    }

    fun getNotes(): List<Note> {
        return notes.toList()
    }

}