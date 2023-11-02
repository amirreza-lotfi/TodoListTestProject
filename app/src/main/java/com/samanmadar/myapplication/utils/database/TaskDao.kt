package com.samanmadar.myapplication.utils.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.samanmadar.myapplication.feature_todolist.domain.model.Task

@Dao
interface TaskDao {
    @Insert
    fun addTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("select * from table_task")
    fun getAllTasks():List<Task>
}