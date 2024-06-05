package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notesapp.data.NotesDataSource
import com.example.notesapp.model.Note
import com.example.notesapp.screen.NoteScreen
import com.example.notesapp.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val notes = remember{
                mutableStateListOf<Note>()
            }
            MyApp {
                NoteScreen(notes = notes,
                    onRemoveNote = {
                        notes.remove(it)
                    },
                    onAddNote = {
                        notes.add(it)
                    })
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    NotesAppTheme(darkTheme = false) {
        content()
    }
}

@Preview
@Composable
fun MyAppPreview(){
    MyApp{
        NoteScreen(notes = NotesDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
    }
}