package com.example.notesapp.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp.R
import com.example.notesapp.components.NoteButton
import com.example.notesapp.components.NoteInputComponent
import com.example.notesapp.components.NoteRow
import com.example.notesapp.data.NotesDataSource
import com.example.notesapp.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit,

){

    val title = remember{
        mutableStateOf("");
    }
    val description = remember {
        mutableStateOf("");
    }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = stringResource(id = R.string.app_name))
            },
                actions = {
                    Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "Icon" )
                }
            )

        }
    ) {
        innerPadding -> Column(modifier = Modifier.padding(innerPadding)){
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                NoteInputComponent(
                    text = title.value.toString(), label = "Title",
                    onTextChange = {
                        if(it.all{ char -> char.isLetter() || char.isWhitespace()
                            }){
                        title.value = it
                        }
                    }, modifier = Modifier
                        .width(350.dp)
                        .padding(top = 10.dp, bottom = 10.dp)
                )
                NoteInputComponent(

                    text = description.value.toString(), label = "Description",
                    onTextChange = {
                        if(it.all{ char -> char.isLetter() || char.isWhitespace()
                            }){
                            description.value = it
                        }
                    }, modifier = Modifier
                        .width(350.dp)
                        .padding(top = 10.dp, bottom = 10.dp)
                )
                NoteButton(
                    modifier = Modifier.padding(top=10.dp,bottom = 10.dp),
                    text = "Add",
                    onClick = {
                        if(title.value.toString().isNotEmpty() && description.value.toString().isNotEmpty()){
                            onAddNote(Note(
                                title = title.value.toString(),
                                description = description.value.toString()))
                            title.value = ""
                            description.value = ""
                            Toast.makeText(context,"Note Added",
                                Toast.LENGTH_SHORT
                                ).show()
                        }
                    }
                )


            }
        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn(modifier = Modifier.padding(10.dp)) {
            items(notes){
                    note-> NoteRow(note = note,
                        onNoteClicked = {
                            onRemoveNote(note)
                        }
                    )
            }
        }
        }

    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun NoteScreenPreview(){
    NoteScreen(notes = NotesDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}