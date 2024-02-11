package com.example.composetutorial.dataSource


import com.example.composetutorial.Data.Response
import com.example.composetutorial.domain.Note

class DummyDataSource {
    suspend fun getAllNotes(): Response<List<Note>> {
        return Response.Success(getData())
    }

    suspend fun getNote(NoteId: String): Response<Note> {
        return Response.Success(getData().first {it.id ==NoteId })
    }

    suspend fun deleteNote(id: String): Response<Nothing> {
        // TODO("Not yet implemented")
        return Response.Failure()
    }

    suspend fun editNote(note: Note): Response<Nothing> {
        //TODO("Not yet implemented")
        return Response.Failure()
    }

    suspend fun addNote(note: Note): Response<Nothing> {
        //TODO("Not yet implemented")
        return Response.Failure()
    }

}