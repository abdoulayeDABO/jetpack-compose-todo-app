package com.abdoulaye.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): Flow<List<Todo>>

    @Query("SELECT * FROM todo")
    fun getAllTodos(): Flow<List<Todo>>

    @Insert
    fun insertAll(vararg todos: Todo)

    @Query("DELETE FROM todo")
    fun deleteAll()

    @Query("SELECT * FROM todo WHERE todoId IN (:todoIds)")
    fun loadAllByIds(todoIds: IntArray): Flow<List<Todo>>

    @Update
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)

    @Insert
    fun insertTodo(todo: Todo)

}