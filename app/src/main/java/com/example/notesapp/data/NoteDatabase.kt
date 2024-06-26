package com.example.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notesapp.converters.DateConverter
import com.example.notesapp.converters.UUIDConverter
import com.example.notesapp.model.Note

@Database(entities = [Note::class],version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}