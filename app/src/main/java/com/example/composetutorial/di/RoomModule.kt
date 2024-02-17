package com.example.composetutorial.di

import android.content.Context
import androidx.room.Room
import com.example.composetutorial.datasource.room.AppDatabase
import com.example.composetutorial.datasource.room.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "note"
        ).build()
    }

    @Provides
    fun provideNoteDao(database: AppDatabase): NoteDao {
        return database.noteDao()
    }
}
