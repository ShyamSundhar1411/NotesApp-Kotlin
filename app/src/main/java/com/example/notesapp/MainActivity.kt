package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.notesapp.screen.NoteScreen
import com.example.notesapp.ui.theme.NotesAppTheme
import com.example.notesapp.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp(notesViewModel: NoteViewModel = viewModel()){
    val notesList = notesViewModel.noteList.collectAsState().value
    NotesAppTheme(darkTheme = false) {
        NoteScreen(notes = notesList,
            onRemoveNote = {
                notesViewModel.removeNote(it)
            },
            onAddNote = {
                notesViewModel.addNote(it)
            })
    }
}

@Preview
@Composable
fun MyAppPreview(){
    MyApp()
}