package com.samanmadar.myapplication.feature_todolist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samanmadar.myapplication.feature_todolist.domain.model.Task
import com.samanmadar.myapplication.feature_todolist.domain.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoListViewModel(
    private val taskRepository: TaskRepository,
): ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>( listOf())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        getTasks()
    }

    private fun getTasks(){
        viewModelScope.launch(Dispatchers.IO){
            _tasks.value = taskRepository.getAllTasks()
        }
    }

    fun addTask(title:String, taskTitle:String, doAfterSave:()->Unit){
        viewModelScope.launch(Dispatchers.IO){
            val newTask = Task(0,title,taskTitle,System.currentTimeMillis())
            taskRepository.addTask(newTask)
            withContext(Dispatchers.Main){
                doAfterSave()
            }
        }

    }

}