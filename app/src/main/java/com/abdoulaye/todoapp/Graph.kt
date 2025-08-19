package com.abdoulaye.todoapp

import android.content.Context
import androidx.room.Room
import com.abdoulaye.todoapp.data.TodoDatabase
import kotlin.getValue
import com.abdoulaye.todoapp.data.TodoRepository

object Graph {
    lateinit var database: TodoDatabase

    val todoRepository by lazy{
        TodoRepository(todoDao = database.todoDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, TodoDatabase::class.java, "todo-db.db").build()
    }

}