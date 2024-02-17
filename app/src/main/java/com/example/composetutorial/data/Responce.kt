package com.example.composetutorial.data

sealed class Response<out T> {
    data class Success<out T>(val result: T) : Response<T>()
    data class Empty(val message: String = "") : Response<Nothing>()
    data class Failure(val message: String = "") : Response<Nothing>()
}
