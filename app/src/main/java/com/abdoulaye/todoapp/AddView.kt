package com.abdoulaye.todoapp

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import androidx.room.Room
import com.abdoulaye.todoapp.components.AppBarView
import com.abdoulaye.todoapp.data.TodoDatabase
import com.abdoulaye.todoapp.data.Todo
//import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale // Ensure this line is present and correct

@Composable
fun AddView(
    modifier: Modifier = Modifier,
    viewModel: TodoViewModel,
    navController: NavController
){

    Scaffold(
        topBar = {
            AppBarView(
                title = "Nouvelle",
                onNavigationIconClick = {
                    navController.navigateUp()
                }
            )
        },

    ){ innerPadding ->
        (
            Surface(modifier = modifier.fillMaxWidth().padding(innerPadding))
            {
                Column(
                    modifier = modifier.fillMaxWidth().padding(16.dp),
                ) {

                    val onAdd: () -> Unit = {
                        if (viewModel.todoTitleState.isNotEmpty()) {
                            viewModel.insertTodo(
                                Todo(title = viewModel.todoTitleState, isDone = false)
                            )
                            viewModel.todoTitleState = ""
                            navController.navigateUp()
                        }
                    }

                    OutlinedTextField(
                        value = viewModel.todoTitleState,
                        onValueChange = { viewModel.onTitleChange(it) },
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 1,
                        textStyle = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        ),
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                            cursorColor = MaterialTheme.colorScheme.primary,
                            focusedTextColor = MaterialTheme.colorScheme.primary,
                            unfocusedTextColor = MaterialTheme.colorScheme.primary
                        )
                    )


                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = onAdd,
                        modifier = Modifier.fillMaxWidth().height(50.dp)
                    ) {
                        Text(text = "Ajouter")
                    }

                }
            }
        )
    }
}
