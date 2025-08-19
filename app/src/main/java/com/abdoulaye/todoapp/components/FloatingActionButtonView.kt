package com.abdoulaye.todoapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FloatingActionButtonView(
    navController: NavController
){
    FloatingActionButton(
        onClick = {
            navController.navigate("add_todo")
        },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
        modifier = Modifier.padding(10.dp),

    ) {
        Icon(Icons.Filled.Add, "Localized description", tint = MaterialTheme.colorScheme.onPrimary )
    }
}