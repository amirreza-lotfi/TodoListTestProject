package com.samanmadar.myapplication.feature_todolist.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val title:String,
    val detail:String,
    val createdTime:Long,
)
