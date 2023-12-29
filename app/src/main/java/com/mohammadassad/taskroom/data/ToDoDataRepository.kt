package com.mohammadassad.taskroom.data
import com.mohammadassad.taskroom.data.DataSource.DB.Entity.ToDoTask
import com.mohammadassad.taskroom.data.DataSource.DB.ToDoDao
import com.mohammadassad.taskroom.data.Repository.ToDoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow


interface ToDoRepository {
    suspend fun getTodos(): Flow<List<ToDoTask>>
    suspend fun addTodos(toDoTask: ToDoTask)
    suspend fun deleteTodos(toDoTask: ToDoTask)
}

@Module
@InstallIn(ViewModelComponent::class)
object ToDoDataRepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideToDoDataRepositoryModule (toDoDao: ToDoDao) : ToDoRepository {
        return ToDoRepositoryImpl(toDoDao);
    }


}





