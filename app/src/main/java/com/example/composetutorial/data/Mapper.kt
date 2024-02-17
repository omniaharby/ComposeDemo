package com.example.composetutorial.data

import com.example.composetutorial.datasource.room.NoteEntity
import com.example.composetutorial.domain.Note
import com.example.composetutorial.domain.NoteColor.Companion.getColorByName
import com.example.composetutorial.domain.NoteColor.Companion.getNameByColor
import com.example.composetutorial.domain.NoteColor.Companion.getRandomNoteColor

fun mapFromNoteEntity(note: NoteEntity): Note {
    return Note(
        note.id.toString(),
        note.title,
        note.description,
        note.date,
        getColorByName(note.color) ?: getRandomNoteColor().color
    )
}

fun mapFromNote(note: Note): NoteEntity {
    return NoteEntity(
        note.id.toInt(),
        note.title,
        note.description,
        note.date,
        getNameByColor(note.color) ?: getRandomNoteColor().name
    )
}