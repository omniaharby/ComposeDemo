package com.example.composetutorial.Data

sealed class Response<T> {
    data class Success<T>(val result: T) : Response<T>()
    data class Failure(val message: String = "") : Response<Nothing>()
}
