package com.samanmadar.myapplication.feature_todolist.data

import com.samanmadar.myapplication.feature_todolist.domain.model.Task
import com.samanmadar.myapplication.feature_todolist.domain.repository.TaskRepository
import com.samanmadar.myapplication.utils.database.TaskDao

class TaskRepositoryImplementation(private val taskDao: TaskDao):TaskRepository {
    override fun addTask(task: Task) {
        taskDao.addTask(task)
    }

    override fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

    override fun getAllTasks(): List<Task> {
        return taskDao.getAllTasks()
    }

}