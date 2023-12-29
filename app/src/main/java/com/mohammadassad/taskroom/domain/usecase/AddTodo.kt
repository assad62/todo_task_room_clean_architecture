package com.mohammadassad.taskroom.domain.usecase

import com.mohammadassad.taskroom.data.DataSource.DB.Entity.ToDoTask
import com.mohammadassad.taskroom.data.ToDoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class AddTodosUseCase @Inject constructor(val repository: ToDoRepository){

    suspend  fun addTodoTask(toDoTask: ToDoTask){
        return repository.addTodos(toDoTask = toDoTask)
    }
}
