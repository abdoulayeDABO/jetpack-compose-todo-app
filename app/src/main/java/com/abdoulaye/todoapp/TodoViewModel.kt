package com.abdoulaye.todoapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdoulaye.todoapp.data.Todo
import com.abdoulaye.todoapp.data.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class TodoViewModel(
//    private val repository : TodoRepository
): ViewModel(){

    private val repository = Graph.todoRepository
    var todoTitleState  by mutableStateOf("")

    fun onTitleChange(newTitle: String){
        todoTitleState = newTitle
    }

    lateinit var getAllTodos: Flow<List<Todo>>


    init {
        viewModelScope.launch(
            Dispatchers.IO
        ){
            getAllTodos = repository.getAllTodos()
            Log.d("TodoList", getAllTodos.toString())
        }
    }

    fun insertTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertTodo(todo)
        }
    }

    fun updateTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateTodo(todo)
        }
    }


    fun deleteTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteTodo(todo)
        }
    }

}