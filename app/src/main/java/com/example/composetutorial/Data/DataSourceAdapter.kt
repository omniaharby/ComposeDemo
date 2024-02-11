package com.example.composetutorial.Data

import com.example.composetutorial.dataSource.DummyDataSource
import com.example.composetutorial.domain.Note
import javax.inject.Inject


class DataSourceAdapter @Inject constructor() : DataSourceContract {

    // Todo: update with real data source
    private val dataSource = DummyDataSource()
    override suspend fun getAllNotes(): Response<List<Note>> {

        return dataSource.getAllNotes()
    }

    override suspend fun getNote(id: String): Response<Note> {
        return dataSource.getNote(id)
    }

    override suspend fun deleteNote(id: String): Response<Nothing> {

        return dataSource.deleteNote(id)
    }

    override suspend fun editNote(note: Note): Response<Nothing> {
        return dataSource.editNote(note)
    }

    override suspend fun addNote(note: Note): Response<Nothing> {
        return dataSource.addNote(note)
    }
}