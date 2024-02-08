package com.example.composetutorial.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composetutorial.domain.Note

@Composable
fun NotesList(data: List<Note>, onNoteClick: (String) -> Unit) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(data) { note ->
            NoteItem(note = note, onNoteClick)
        }
    }
}

