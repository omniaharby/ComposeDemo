package com.example.composetutorial.Data

interface DataSourceContract<T> {
    suspend fun getAllNotes(): Response<List<T>>
    suspend fun getNote(id: String): Response<T>
    suspend fun deleteNote(id: String): Response<Nothing>
    suspend fun addNote(note: T): Response<Nothing>
    suspend fun editNote(note: T): Response<Nothing>
}