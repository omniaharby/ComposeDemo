package com.example.composetutorial.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(val route: String, val navArgs: List<NamedNavArgument> = emptyList()) {

    data object Home : Screen(route = "Home")

    data object NoteScreen : Screen(
        route = "NoteScreen/{NoteId}",
        navArgs = listOf(navArgument("NoteId") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(noteId: String) = "NoteScreen/${noteId}"
    }
}