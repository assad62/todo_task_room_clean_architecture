package com.mohammadassad.taskroom.data.Repository

import com.mohammadassad.taskroom.data.DataSource.DB.Entity.ToDoTask
import com.mohammadassad.taskroom.data.DataSource.DB.ToDoDao
import com.mohammadassad.taskroom.data.ToDoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(private val todoDao:ToDoDao): ToDoRepository {

    override suspend fun getTodos(): Flow<List<ToDoTask>> {
        return todoDao.getAllTasks()
    }

    override suspend fun addTodos(toDoTask: ToDoTask) {
        return todoDao.addTask(toDoTask)
    }

    override suspend fun deleteTodos(toDoTask: ToDoTask) {
       return todoDao.deleteTask(toDoTask)
    }
}