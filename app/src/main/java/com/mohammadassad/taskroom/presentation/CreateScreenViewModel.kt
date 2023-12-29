package com.mohammadassad.taskroom.presentation

import androidx.lifecycle.ViewModel
import com.mohammadassad.taskroom.data.DataSource.DB.Entity.ToDoTask
import com.mohammadassad.taskroom.domain.usecase.AddTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CreateScreenViewModel @Inject constructor(
   private val createUseCase: AddTodosUseCase,

) :
   ViewModel() {

   suspend fun addTask(title:String, description:String) {

      val task = ToDoTask(
         title = title,
         description = description
      )

      createUseCase.addTodoTask(task)
   }



}