package com.mohammadassad.taskroom.domain.usecase

//import kotlinx.coroutines.flow.internal.NopCollector.emit
//import kotlinx.coroutines.flow.internal.NopCollector.emit
import com.mohammadassad.taskroom.core.Resource
import com.mohammadassad.taskroom.data.DataSource.DB.Entity.ToDoTask
import com.mohammadassad.taskroom.data.ToDoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject


@ViewModelScoped
class GetTodosUseCase @Inject constructor(private val repository: ToDoRepository){
    suspend operator fun invoke(): Flow<Resource<List<ToDoTask>>> = flow {


        try {
            emit(Resource.Loading())
            repository.getTodos().collect{
                emit(Resource.Success(it))
            }

        }
        catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }





    }
}
