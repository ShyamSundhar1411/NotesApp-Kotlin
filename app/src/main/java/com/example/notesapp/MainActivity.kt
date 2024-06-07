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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notesapp.data.NotesDataSource
import com.example.notesapp.model.Note
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