package com.abdoulaye.todoapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdoulaye.todoapp.Screen

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
        viewModel: TodoViewModel = viewModel()
) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route,) {
            HomeView(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(Screen.AddScreen.route) {
            AddView(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}