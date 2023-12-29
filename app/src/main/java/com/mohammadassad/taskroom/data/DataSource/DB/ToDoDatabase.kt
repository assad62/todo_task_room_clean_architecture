package com.mohammadassad.taskroom.data.DataSource.DB

import com.mohammadassad.taskroom.data.DataSource.DB.Entity.ToDoTask


import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohammadassad.taskroom.data.DataSource.DB.ToDoDao

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

}