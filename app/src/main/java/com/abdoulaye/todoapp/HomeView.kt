package com.abdoulaye.todoapp

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.room.Room
import com.abdoulaye.todoapp.components.AppBarView
import com.abdoulaye.todoapp.components.FloatingActionButtonView
import com.abdoulaye.todoapp.components.TodoItem
import com.abdoulaye.todoapp.data.TodoDatabase
import com.abdoulaye.todoapp.data.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.Flow


@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    viewModel: TodoViewModel,
    navController: NavController
){

    val context = LocalContext.current
    fun onCheckedChange(todo: Todo){}
    fun onDelete(todo: Todo){}
    val todoList = viewModel.getAllTodos.collectAsState(initial = listOf())
    Log.d("TodoList", todoList.value.toString())

    Scaffold(
        topBar = {
            AppBarView(
                title = "Todo App",
                onNavigationIconClick = { /*TODO*/ }
            )
        },
        floatingActionButton = { FloatingActionButtonView(navController) }

    ){ innerPadding ->
        (
            if(viewModel.getAllTodos.collectAsState(initial = listOf()).value.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "No Todos",
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "Add your first todo to get started",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(PaddingValues(horizontal = 16.dp, vertical = 16.dp)),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    items(todoList.value){ todo ->
                        TodoItem(
                            todo = todo,
                            onCheckedChange = {
                             viewModel.updateTodo(todo.copy(isDone = it))
                            },
                            onDelete = {
                                viewModel.deleteTodo(todo)
                            }
                        )
                    }
                }
            }
        )
    }
}

