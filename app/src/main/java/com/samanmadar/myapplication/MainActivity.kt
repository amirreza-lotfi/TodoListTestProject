package com.samanmadar.myapplication

import com.samanmadar.myapplication.feature_todolist.presentation.screen_add_task.AddNewTaskScreen
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.samanmadar.myapplication.feature_todolist.presentation.TodoListViewModel
import com.samanmadar.myapplication.feature_todolist.presentation.screen_show_tasks.ShowAllTasksScreen
import com.samanmadar.myapplication.utils.ui_utill.TodoListTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            val navController = rememberNavController()
            val viewModel by inject<TodoListViewModel>()
            TodoListTheme{
                NavHost(
                    navController = navController, startDestination = SHOW_ALL_TASKS
                ) {

                    composable(route = SHOW_ALL_TASKS) {
                        ShowAllTasksScreen(navController, viewModel)
                    }
                    composable(route = ADD_NEW_TASK) {
                        AddNewTaskScreen(navController, viewModel)
                    }
                }
            }
        }
    }

    companion object {
        const val SHOW_ALL_TASKS = "SHOW_ALL_TASKS"
        const val ADD_NEW_TASK = "SHOW_ALL_TASKS"
    }
}