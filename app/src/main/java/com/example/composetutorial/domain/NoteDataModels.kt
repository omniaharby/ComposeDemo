package com.example.composetutorial.domain

import androidx.compose.ui.graphics.Color

data class Note(
    val id: String,
    val title: String = "No Title",
    val description: String = "",
    val date: String,
    val color: Color
)