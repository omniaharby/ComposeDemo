package com.example.composetutorial.domain

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

enum class NoteColor(val color: Color) {
    PINK(Color(0XFFFFB5E8)),
    PURPLE(Color(0XFFC5A3FF)),
    GREEN(Color(0XFFF3FFE3)),
    BLUE(Color(0XFFAFF8D8)),
    PEACH(Color(0XFFFFCBC1)),
    LIGHT_BLUE(Color(0XFFAFCBFF));

    companion object {
        fun getColorByName(name: String): Color? {
            return entries.find { it.name.equals(name, ignoreCase = true) }?.color
        }

        fun getNameByColor(colorValue: Color): String? {
            return entries.find { it.color == colorValue }?.name
        }

        fun getRandomNoteColor(): NoteColor {
            return entries[Random.nextInt(entries.size)]
        }
    }
}