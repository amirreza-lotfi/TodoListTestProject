package com.samanmadar.myapplication.feature_todolist.presentation.screen_add_task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samanmadar.myapplication.feature_todolist.presentation.TodoListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewTaskScreen(navController: NavController, todoListViewModel: TodoListViewModel) {
    val titleString = remember { mutableStateOf("") }
    val taskDetailString = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        TextField(
            value = "",
            onValueChange = { titleString.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            textStyle = MaterialTheme.typography.bodyMedium,
            placeholder = {
                "عنوان تسک"
            },
        )

        TextField(
            value = "",
            onValueChange = { taskDetailString.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(top = 16.dp),
            textStyle = MaterialTheme.typography.bodyMedium,
            placeholder = {
                "جزئیات تسک"
            }
        )


        Button(
            onClick = {
                todoListViewModel.addTask(titleString.value, taskDetailString.value){
                    navController.popBackStack()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        ) {
            Text(text = "ذخیره")
        }
    }
}