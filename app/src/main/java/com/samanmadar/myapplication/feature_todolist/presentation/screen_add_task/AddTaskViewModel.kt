package com.samanmadar.myapplication.feature_todolist.presentation.screen_add_task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samanmadar.myapplication.feature_todolist.domain.model.Task
import com.samanmadar.myapplication.feature_todolist.domain.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddTaskViewModel(
    private val taskRepository: TaskRepository,
):ViewModel() {
    private val _title = MutableLiveData("")

    private val _taskDetail = MutableLiveData("")


    fun addTask(doAfterSave:()->Unit){
        viewModelScope.launch(Dispatchers.IO){
            val newTask = Task(0,_title.value ?: "",_taskDetail.value ?: "",System.currentTimeMillis())
            taskRepository.addTask(newTask)
            withContext(Dispatchers.Main){
                doAfterSave()
            }
        }

    }


    fun setTaskTitle(value:String) = run { _title.value = value }
    fun setTaskDetail(value:String) = run { _taskDetail.value = value }
}