package com.example.composetutorial.ui.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetutorial.domain.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteScreenViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    val noteId: String = savedStateHandle.get<String>(KEY_NOTE_ID)!!
    val noteLiveData = MutableLiveData<Note>()

    init {
        getNote()
    }


    fun getNote() {
        viewModelScope.launch(Dispatchers.IO) {
            noteLiveData.postValue(_getNote(noteId))
        }
    }

    fun saveNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            _saveNote(note)
        }
    }

    fun deleteNote(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _deleteNote(id)
        }
    }

    private suspend fun _getNote(id: String): Note {
        TODO("Not yet implemented")
    }

    private suspend fun _saveNote(note: Note) {
        TODO("Not yet implemented")
    }

    private suspend fun _deleteNote(id: String) {
        TODO("Not yet implemented")
    }
}

const val KEY_NOTE_ID = "NoteId"