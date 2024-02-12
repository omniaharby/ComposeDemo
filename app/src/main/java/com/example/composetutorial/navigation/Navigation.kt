package com.example.composetutorial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetutorial.ui.screens.HomeScreen
import com.example.composetutorial.ui.screens.NoteScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onNoteClick = {
                    navController.navigate(
                        Screen.NoteScreen.createRoute(
                            noteId = it
                        )
                    )
                }
            )
        }

        composable(
            route = Screen.NoteScreen.route,
            arguments = Screen.NoteScreen.navArgs
        ) {
            NoteScreen(onBackClick = { navController.navigateUp() })
        }
    }
}