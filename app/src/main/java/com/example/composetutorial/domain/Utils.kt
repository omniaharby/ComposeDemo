package com.example.composetutorial.domain

import androidx.compose.ui.graphics.Color

fun getRandomColour(): Color {
    return NoteColorList.random()
}

private val NoteColorList = listOf(
    Color(0XFFFFB5E8),
    Color(0XFFC5A3FF),
    Color(0XFFF3FFE3),
    Color(0XFFAFF8D8),
    Color(0XFFFFCBC1),
    Color(0XFFAFCBFF)
)