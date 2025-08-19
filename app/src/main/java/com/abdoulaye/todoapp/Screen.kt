package com.abdoulaye.todoapp

sealed class Screen(
    val route: String,
) {
    object HomeScreen : Screen("home")
    object AddScreen : Screen("add_todo")
}