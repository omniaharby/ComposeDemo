package com.example.composetutorial.data

import com.example.composetutorial.datasource.room.NoteDao
import com.example.composetutorial.domain.Note
import javax.inject.Inject

class DataSourceAdapter @Inject constructor(val noteDao: NoteDao) : DataSourceContract {
    override suspend fun getAllNotes(): Response<List<Note>> {

        return try {
            val result = noteDao.getAllNotes()
            if (result != null) {
                Response.Success(result.map { mapFromNoteEntity(it) })
            } else {
                Response.Empty("Notes are empty")
            }
        } catch (e: Error) {
            Response.Failure("Failed loading notes$e")
        }
    }

    override suspend fun getNote(id: String): Response<Note> {
        return try {
            val result = noteDao.getNoteById(id.toInt())
            if (result != null) {
                Response.Success(mapFromNoteEntity(result))
            } else {
                Response.Empty(" Note not found")
            }

        } catch (e: Error) {
            Response.Failure("Failed fetching Note $e")
        }
    }

    override suspend fun deleteNote(id: String): Response<String> {

        return try {
            noteDao.deleteById(id.toInt())
            Response.Success("deleted successfully")
        } catch (e: Error) {
            Response.Failure("Failed to delete note $e")
        }
    }

    override suspend fun editNote(note: Note): Response<String> {
        return try {
            noteDao.updateNote(mapFromNote(note))
            Response.Success("Updated successfully")
        } catch (e: Error) {
            Response.Failure("Failed to update note $e")
        }
    }

    override suspend fun addNote(note: Note): Response<String> {
        return try {
            noteDao.insert(mapFromNote(note))
            Response.Success("Saved successfully")
        } catch (e: Error) {
            Response.Failure("Failed to save note $e")
        }
    }
}