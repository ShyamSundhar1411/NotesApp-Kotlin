package com.example.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.model.Note

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * from notes_table")
    fun getNotes(): List<Note>

    @Query("SELECT * from notes_table where id=:id")
    fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note:Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note:Note)

    @Query("DELETE from notes_table")
    fun deleteAllNotes()

    @Delete
    fun deleteNote(note:Note)
}
