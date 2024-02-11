package com.example.composetutorial.ui.screens

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

    val notesLiveData = MutableLiveData<List<Note>>(listOf())

    init {
        refreshData()
    }

    fun refreshData() {
        viewModelScope.launch(Dispatchers.IO) {
            _getNotes()
        }
    }

    fun deleteNote(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _deleteNote(id)
        }
    }

    private suspend fun _getNotes() {


        when (val response = repository.getAllNotes()) {
            is Response.Success<List<Note>> -> {
                notesLiveData.postValue(response.result)
            }

            else -> {
                TODO("Not yet implemented")
            }
        }

    }

    private suspend fun _deleteNote(id: String) {
        val result = repository.deleteNote(id)
        when (result) {
            is Response.Success -> {
                TODO("Not yet implemented")
            }

            else -> {
                TODO("Not yet implemented")
            }
        }

    }
}