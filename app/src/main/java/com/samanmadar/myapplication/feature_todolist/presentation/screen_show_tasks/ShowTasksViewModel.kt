package com.samanmadar.myapplication.feature_todolist.presentation.screen_show_tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samanmadar.myapplication.feature_todolist.domain.model.Task
import com.samanmadar.myapplication.feature_todolist.domain.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowTasksViewModel(private val taskRepository: TaskRepository) : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>( listOf())
    val tasks: LiveData<List<Task>> = _tasks


    fun getTasks(){
        viewModelScope.launch(Dispatchers.IO){
            _tasks.postValue(taskRepository.getAllTasks())
        }
    }
}