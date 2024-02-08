package com.example.composetutorial.ui.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetutorial.dataSource.getData
import com.example.composetutorial.domain.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    val notesLiveData = MutableLiveData<List<Note>>(listOf())

    init {
        refreshData()
    }

    fun refreshData() {
        viewModelScope.launch(Dispatchers.IO) {
            notesLiveData.postValue(_getNotes())
        }
    }

    fun deleteNote(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _deleteNote(id)
        }
    }

    private suspend fun _getNotes(): List<Note> {
        TODO("Not yet implemented")
        return getData()
    }

    private suspend fun _deleteNote(id: String) {
        TODO("Not yet implemented")
    }
}