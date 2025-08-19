package com.abdoulaye.todoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)  val todoid: Int = 0,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "isDone") val isDone: Boolean?

)