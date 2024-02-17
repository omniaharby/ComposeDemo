package com.example.composetutorial.ui.screens

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetutorial.data.Repository
import com.example.composetutorial.data.Response
import com.example.composetutorial.domain.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(val repository: Repository) : ViewModel() {


    private var _notesList: List<Note> = listOf()
    val query = MutableLiveData("")
    val filteredNotesLiveData = MediatorLiveData<List<Note>>(listOf()).apply {
        addSource(query) { _query ->

            if (!query.value.isNullOrBlank()) {
                this.value = searchNotes(_query, _notesList)
            } else {
                this.value = _notesList
            }
        }
    }

    val isEmptyState = MediatorLiveData<Boolean>().apply {
        addSource(filteredNotesLiveData) {
            value = it.isEmpty()
        }
    }

    init {
        getAllNotes()
    }


    fun getAllNotes() {
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

    private fun searchNotes(query: String, noteList: List<Note>): List<Note> {
        return query.lowercase(Locale.getDefault()).let { updatedQuery ->
            noteList.filter {
                it.title.lowercase(Locale.getDefault())
                    .contains(updatedQuery) || it.description.lowercase(Locale.getDefault())
                    .contains(updatedQuery)
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