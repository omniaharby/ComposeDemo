package com.example.composetutorial.ui.screens

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetutorial.Data.Repository
import com.example.composetutorial.Data.Response
import com.example.composetutorial.domain.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(val repository: Repository) : ViewModel() {


    private var _notesList: List<Note> = listOf()
    val query = MutableLiveData("")
    val filteredNotesLiveData = MediatorLiveData<List<Note>>().apply {
        addSource(query) { _query ->

            if (!query.value.isNullOrBlank()) {
                this.value = searchNotes(_query, _notesList)
            } else {
                this.value = _notesList
            }
        }
    }

    init {
        gatAllNotes()
    }

    private fun searchNotes(query: String, noteList: List<Note>): List<Note> {
        return query.toLowerCase().let { updatedQuery ->
            noteList.filter {
                it.title.toLowerCase().contains(updatedQuery) || it.description.toLowerCase()
                    .contains(updatedQuery)
            }
        }
    }

    private fun gatAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = repository.getAllNotes()) {
                is Response.Success<List<Note>> -> {
                    _notesList = response.result
                    filteredNotesLiveData.postValue(_notesList)
                }

                else -> {
                    TODO("Not yet implemented")
                }
            }
        }
    }

    fun deleteNoteFromRepo(id: String) {
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

}