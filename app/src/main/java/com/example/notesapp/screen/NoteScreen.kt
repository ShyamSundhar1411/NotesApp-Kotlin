package com.example.notesapp.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NoteScreen(){
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

        }
    }
}