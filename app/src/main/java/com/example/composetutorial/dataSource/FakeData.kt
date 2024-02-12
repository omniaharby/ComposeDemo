package com.example.composetutorial.dataSource

import com.example.composetutorial.domain.Note
import com.example.composetutorial.domain.getRandomColour

fun getData() = listOf(
    Note(
        "1", "Diary",
        "compose doesn't require that you use MutableState<T> to hold state;" +
                " it supports other observable types. Before reading another observable type " +
                "in Compose, you must convert it to a State<T> so that composables can automatically " +
                "recompose when the state changes.", "15 2 1996", getRandomColour()
    ),
    Note(
        "2", "Diary",
        "compose doesn't require that you use MutableState<T> to hold state;" +
                " it supports other observable types. Before reading another observable type " +
                "in Compose, you must convert it to a State<T> so that composables can automatically " +
                "recompose when the state changes.", "15 2 1996", getRandomColour()
    ),
    Note(
        "3", "The New Theory",
        "compose doesn't require that you use MutableState<T> to hold state;" +
                " it supports other observable types. Before reading another observable type " +
                "in Compose, you must convert it to a State<T> so that composables can automatically " +
                "recompose when the state changes.", "15 2 1996", getRandomColour()
    ),
    Note(
        "4", "EL tmama awy",
        "compose doesn't require that you use MutableState<T> to hold state;" +
                " it supports other observable types. Before reading another observable type " +
                "in Compose, you must convert it to a State<T> so that composables can automatically " +
                "recompose when the state changes.", "15 2 1996", getRandomColour()
    )

)