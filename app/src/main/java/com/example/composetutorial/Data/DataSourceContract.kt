package com.example.composetutorial.Data

import com.example.composetutorial.domain.Note

interface DataSourceContract {
    suspend fun getAllNotes(): Response<List<Note>>
    suspend fun getNote(id: String): Response<Note>
    suspend fun deleteNote(id: String): Response<Nothing>
    suspend fun addNote(note: Note): Response<Nothing>
    suspend fun editNote(note: Note): Response<Nothing>
}