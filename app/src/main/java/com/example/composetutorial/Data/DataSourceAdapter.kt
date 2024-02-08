package com.example.composetutorial.Data

import android.provider.ContactsContract.CommonDataKinds.Note

class DataSourceAdapter:DataSourceContract<Note> {
    override suspend fun getAllNotes(): Response<List<Note>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNote(id: String): Response<Note> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(id: String): Response<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun editNote(note: Note): Response<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun addNote(note: Note): Response<Nothing> {
        TODO("Not yet implemented")
    }

}