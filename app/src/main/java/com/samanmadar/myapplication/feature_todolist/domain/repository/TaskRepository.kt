package com.samanmadar.myapplication.feature_todolist.domain.repository

import com.samanmadar.myapplication.feature_todolist.domain.model.Task

interface TaskRepository {
    fun addTask(task: Task)
    fun deleteTask(task:Task)
    fun getAllTasks():List<Task>
}