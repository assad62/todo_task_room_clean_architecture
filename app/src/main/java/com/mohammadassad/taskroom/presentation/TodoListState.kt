package com.mohammadassad.taskroom.presentation

import com.mohammadassad.taskroom.data.DataSource.DB.Entity.ToDoTask


data class TodoListState(
    val isLoading: Boolean = false,
    val todoList: List<ToDoTask> = listOf(),
    val error: String = ""
)