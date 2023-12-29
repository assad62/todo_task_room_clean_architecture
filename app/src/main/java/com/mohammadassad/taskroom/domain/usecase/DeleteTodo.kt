package com.mohammadassad.taskroom.domain.usecase

import com.mohammadassad.taskroom.data.DataSource.DB.Entity.ToDoTask
import com.mohammadassad.taskroom.data.ToDoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class DeleteTodosUseCase @Inject constructor(private val repository: ToDoRepository){

    suspend  fun deleteTodoTask(toDoTask: ToDoTask){
        return repository.deleteTodos(toDoTask)
    }
}
