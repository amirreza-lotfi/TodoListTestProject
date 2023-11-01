package com.samanmadar.myapplication.utils

import android.app.Application
import androidx.room.Room
import com.samanmadar.myapplication.utils.database.TaskDao
import com.samanmadar.myapplication.utils.database.TodoListDatabase
import org.koin.dsl.module

class TodoApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        val databaseConnectionModules = module {
            single{
                Room.databaseBuilder(
                    this@TodoApplication,
                    TodoListDatabase::class.java,
                    "todolist_db"
                ).build()
            }

            single<TaskDao> {
                get<TodoListDatabase>().getTaskDao()
            }
        }
    }
}