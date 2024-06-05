package com.example.notesapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.notesapp.data.NotesDataSource
import com.example.notesapp.model.Note

class NoteViewModel: ViewModel(){
    private var noteList = mutableStateListOf<Note>()

    init{
        noteList.addAll(NotesDataSource().loadNotes())
    }
    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note>{
        return noteList
    }
}