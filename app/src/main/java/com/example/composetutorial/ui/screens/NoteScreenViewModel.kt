package com.example.composetutorial.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetutorial.Data.Repository
import com.example.composetutorial.Data.Response
import com.example.composetutorial.domain.Note
import com.example.composetutorial.domain.getRandomColour
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteScreenViewModel @Inject constructor(
    val repository: Repository, savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _noteId: String? = savedStateHandle.get<String>(KEY_NOTE_ID)
    private lateinit var _note: Note
    val isEditModeEnabled = MutableLiveData(false)
    private val _noteLiveData = MutableLiveData<Note>()
    val noteLiveData: LiveData<Note>
        get() = _noteLiveData

    init {
        if (_noteId != null) {
            getNoteById(_noteId)
        } else {
            isEditModeEnabled.postValue(true)
            createNewNote()
        }
    }

    private fun createNewNote() {
        _note = Note(
            id = "", date = getDate(), color = getRandomColour()
        )
        saveNoteToRepository(_note)
    }

    fun updateNoteTitle(title: String) {
        noteLiveData.value?.let {
            _noteLiveData.value = _updateNoteWithFields(title = title, note = it)
        }
    }

    fun updateNoteDescription(description: String) {
        noteLiveData.value?.let {
            _noteLiveData.value = _updateNoteWithFields(description = description, note = it)
        }
    }

    fun onToggleEditMode() {
        if (isEditModeEnabled.value == true) {
            noteLiveData.value?.also {
                if (it.title != _note.title || it.description != _note.description) {
                    updateNoteInRepository(it)
                }
            }
        }
        isEditModeEnabled.value = !isEditModeEnabled.value!!
    }

    fun getNoteById(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = repository.getNote(id)) {
                is Response.Success<Note> -> {
                    _note = response.result
                    _noteLiveData.postValue(_note)
                }

                else -> {
                    TODO("Not yet implemented")
                }
            }

        }
    }

    private fun updateNoteInRepository(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            when (repository.editNote(note)) {
                is Response.Success -> {
                    getNoteById(_noteId!!)
                }

                else -> {
                    TODO("Not yet implemented")
                }
            }
        }
    }

    fun saveNoteToRepository(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            when (repository.addNote(note)) {
                is Response.Success -> {
                    _noteLiveData.postValue(note)
                }

                else -> {
                    TODO("Not yet implemented")
                }
            }
        }
    }

    fun deleteNoteInRepository(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (repository.deleteNote(id)) {
                is Response.Success -> {
                    TODO("Not yet implemented")
                }

                else -> {
                    TODO("Not yet implemented")
                }
            }
        }
    }

    private fun getDate(): String {
        // todo implement
        return "15/2/1996"
    }

    private fun _updateNoteWithFields(
        title: String? = null, description: String? = null, note: Note
    ): Note {
        return Note(
            note.id, title ?: note.title, description ?: note.description, note.date, note.color
        )
    }
}

const val KEY_NOTE_ID = "NoteId"