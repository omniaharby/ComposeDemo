package com.example.composetutorial.datasource.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteEntity): Long

    @Query("SELECT * FROM note")
    suspend fun getAllNotes(): List<NoteEntity>?

    @Query("SELECT * FROM note WHERE id = :noteId")
    suspend fun getNoteById(noteId: Int): NoteEntity?

    @Query("DELETE FROM note WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Update
    suspend fun updateNote(note: NoteEntity)
}

