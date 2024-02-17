package com.example.composetutorial.data

import com.example.composetutorial.domain.Note
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val dataSource: DataSourceContract) {

    suspend fun getAllNotes(): Response<List<Note>> {
        return dataSource.getAllNotes()
    }

    suspend fun getNote(id: String): Response<Note> {
        return dataSource.getNote(id)
    }

    suspend fun deleteNote(id: String): Response<String> {
        return dataSource.deleteNote(id)
    }

    suspend fun addNote(note: Note): Response<String> {
        return dataSource.addNote(note)
    }

    suspend fun editNote(note: Note): Response<String> {
        return dataSource.editNote(note)
    }
}