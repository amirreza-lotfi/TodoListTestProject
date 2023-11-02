package com.samanmadar.myapplication.feature_todolist.presentation.screen_show_tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samanmadar.myapplication.MainActivity
import com.samanmadar.myapplication.feature_todolist.presentation.TodoListViewModel


@Composable
fun ShowAllTasksScreen(navController: NavController, todoListViewModel: TodoListViewModel) {
    val tasks by todoListViewModel.tasks.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        ExtendedFloatingActionButton(onClick = {
            navController.navigate(MainActivity.ADD_NEW_TASK)
        },content = {}, modifier = Modifier.padding(end = 24.dp, bottom = 24.dp)
        )


        LazyColumn {
            items(tasks) { task ->
                TaskItem(task)
            }
        }
    }
}

