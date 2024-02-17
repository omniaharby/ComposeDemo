package com.example.composetutorial.data

import com.example.composetutorial.data.Response
import com.example.composetutorial.domain.Note

interface DataSourceContract {
    suspend fun getAllNotes(): Response<List<Note>>
    suspend fun getNote(id: String): Response<Note>
    suspend fun deleteNote(id: String): Response<String>
    suspend fun addNote(note: Note): Response<String>
    suspend fun editNote(note: Note): Response<String>
}