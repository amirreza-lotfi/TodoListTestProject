package com.samanmadar.myapplication.utils

import android.app.Application
import androidx.room.Room
import com.samanmadar.myapplication.feature_todolist.data.TaskRepositoryImplementation
import com.samanmadar.myapplication.feature_todolist.domain.repository.TaskRepository
import com.samanmadar.myapplication.feature_todolist.presentation.TodoListViewModel
import com.samanmadar.myapplication.utils.database.TaskDao
import com.samanmadar.myapplication.utils.database.TodoListDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
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

            factory<TaskRepository> {
                TaskRepositoryImplementation(get())
            }
        }
        val viewModelsModule = module {
            viewModel {
                TodoListViewModel(get())
            }
        }
        startKoin {
            androidContext(this@TodoApplication)
            modules(listOf(databaseConnectionModules, viewModelsModule))
        }
    }
}