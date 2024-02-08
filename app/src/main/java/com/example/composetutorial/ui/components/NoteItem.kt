package com.example.composetutorial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.dataSource.getData
import com.example.composetutorial.domain.Note

@Composable
fun NoteItem(note: Note, onNoteClick: (String) -> Unit) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onNoteClick(note.id) })
        ) {
            Column(
                modifier = Modifier
                    .background(note.color)
                    .padding(8.dp),
            )
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = note.title,
                        fontSize = 20.sp
                    )
                    Text(
                        text = note.date,
                        fontSize = 14.sp
                    )
                }

                Text(
                    text = note.description,
                    maxLines = 1
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewNoteItem() {
    NoteItem(getData()[0], {})
}