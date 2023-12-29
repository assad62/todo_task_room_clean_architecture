package com.mohammadassad.taskroom.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammadassad.taskroom.core.Resource
import com.mohammadassad.taskroom.data.DataSource.DB.Entity.ToDoTask
import com.mohammadassad.taskroom.domain.usecase.DeleteTodosUseCase
import com.mohammadassad.taskroom.domain.usecase.GetTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private  val getTodosUseCase: GetTodosUseCase,
    private  val deleteTodosUseCase: DeleteTodosUseCase
) :ViewModel() {

    private val _state = mutableStateOf(TodoListState())
    val state: State<TodoListState> get()= _state

    suspend fun getAllTask(){


        getTodosUseCase().onEach { result ->

            when (result) {
                is Resource.Success -> {
                    _state.value = TodoListState(
                        todoList = result.data!!
                    )
                }
                is Resource.Error -> {
                    _state.value = TodoListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = TodoListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)

    }

    suspend fun deleteTask(task: ToDoTask){
        deleteTodosUseCase.deleteTodoTask(toDoTask = task)
    }

}