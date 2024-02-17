package com.example.composetutorial.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetutorial.ui.components.NotesList
import com.example.composetutorial.ui.components.ToolBar
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

@Composable
fun HomeScreen(onNoteClick: (String?) -> Unit, viewModel: HomeScreenViewModel = hiltViewModel()) {
    var query by remember { mutableStateOf("") }
    val onQueryChanged: (String) -> Unit = {
        query = it
        viewModel.query.postValue(it)
    }
    val isEmpty by viewModel.isEmptyState.observeAsState()
    val noteList by viewModel.filteredNotesLiveData.observeAsState()

    LaunchedEffect(true) {
        viewModel.getAllNotes()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onNoteClick(null) },
                content = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "search",
                        modifier = Modifier
                            .size(25.dp)
                    )
                })
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            ToolBar(query, onQueryChanged)
            if (isEmpty == true) {
                Text(text = "Notes are empty", modifier = Modifier.padding(25.dp))
            }
            noteList?.also { NotesList(it, onNoteClick) }

        }
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
