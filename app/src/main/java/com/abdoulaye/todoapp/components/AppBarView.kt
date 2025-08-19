package com.abdoulaye.todoapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView(
    modifier: Modifier = Modifier,
    title: String = "",
    onNavigationIconClick: () -> Unit
){
    val navigationIcon: @Composable () -> Unit = {
        if(!title.contains("Todo App")){
            IconButton(onClick = { onNavigationIconClick()}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    modifier = Modifier.size(40.dp),
                    tint = Color.White,
                    contentDescription = "Go back"
                )
            }
        }
    }

    TopAppBar(
        title = {Text(text = title, fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.SemiBold)},
        modifier = modifier.then(
            Modifier.background(Color.Blue)
        ),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        navigationIcon = navigationIcon
    )
}