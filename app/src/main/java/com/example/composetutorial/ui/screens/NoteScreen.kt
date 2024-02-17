package com.example.composetutorial.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NoteScreen(viewModel: NoteScreenViewModel = hiltViewModel(), onBackClick: () -> Unit) {

    val note by viewModel.noteLiveData.observeAsState()
    val enableEdit by viewModel.isEditModeEnabled.observeAsState()

    note?.also { _note ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(_note.color)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = _note.title,
                    enabled = enableEdit ?: false,
                    onValueChange = { viewModel.updateNoteTitle(it) },
                    modifier = Modifier
                        .background(_note.color)
                        .padding(8.dp),
                    textStyle = TextStyle(fontSize = 24.sp),
                    colors = TextFieldDefaults.colors(
                        unfocusedTextColor = Color.DarkGray,
                        disabledTextColor = Color.Black,
                        disabledIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                    )
                )
                IconButton(onClick = { viewModel.onToggleEditMode() }) {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        modifier = if (enableEdit == true)
                            Modifier.background(
                                color = Color(0xFA, 0xF8, 0xF8, 0x4F),
                                shape = CircleShape
                            )
                        else Modifier.background(color = Color.Transparent),
                        contentDescription = "go back to main screen "
                    )
                }
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "go back to main screen "
                    )
                }
            }
            Text(
                text = _note.date,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(16.dp)
            )
            val containerColor = Color(0xFA, 0xF8, 0xF8, 0x4F)
            TextField(
                value = _note.description,
                enabled = enableEdit ?: false,
                onValueChange = { viewModel.updateNoteDescription(it) },
                colors = TextFieldDefaults.colors(
                    unfocusedTextColor = Color.DarkGray,
                    disabledTextColor = Color.Black,
                    focusedContainerColor = containerColor,
                    unfocusedContainerColor = containerColor,
                    disabledContainerColor = containerColor,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black,
                    disabledIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(_note.color)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotePage() {
    NoteScreen {}
}