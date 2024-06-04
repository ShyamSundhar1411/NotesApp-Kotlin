package com.example.notesapp.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp.R
import com.example.notesapp.components.NoteButton
import com.example.notesapp.components.NoteInputComponent

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NoteScreen(){
    val title = remember{
        mutableStateOf("");
    }
    val description = remember {
        mutableStateOf("");
    }
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
        innerPadding -> Box(modifier = Modifier.padding(innerPadding)){
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
                    }, modifier = Modifier.width(350.dp).padding(top = 10.dp,bottom = 10.dp)
                )
                NoteInputComponent(

                    text = description.value.toString(), label = "Description",
                    onTextChange = {
                        if(it.all{ char -> char.isLetter() || char.isWhitespace()
                            }){
                            description.value = it
                        }
                    }, modifier = Modifier.width(350.dp).padding(top = 10.dp,bottom = 10.dp)
                )
                NoteButton(modifier = Modifier.padding(top=10.dp,bottom = 10.dp),text = "Add", onClick = { /*TODO*/ })
            }
        }
    }
}