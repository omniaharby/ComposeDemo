package com.example.composetutorial.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetutorial.ui.components.NotesList
import com.example.composetutorial.ui.components.ToolBar
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

@Composable
fun HomeScreen(onNoteClick: (String) -> Unit, viewModel: HomeScreenViewModel = hiltViewModel()) {
    var query by remember { mutableStateOf("") }

    val onQueryChanged: (String) -> Unit = {
        query = it
        //todo : implement search action
    }

    val data by viewModel.notesLiveData.observeAsState()

    Column {
        ToolBar(query, onQueryChanged)
        data?.also { NotesList(it, onNoteClick) }
        // todo: handle empty state
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTutorialTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            HomeScreen({})
        }
    }
}
