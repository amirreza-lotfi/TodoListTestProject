package com.samanmadar.myapplication.utils.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.samanmadar.myapplication.feature_todolist.domain.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TodoListDatabase: RoomDatabase() {
    abstract fun getTaskDao():TaskDao
}