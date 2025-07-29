package com.example.tasknest

import kotlinx.coroutines.flow.Flow

class TaskRepository (private val dao:TaskDao)
{

    val task: Flow<List<ListItems>> =dao.getTasks()


    suspend fun addTask(task:ListItems) {
        dao.addTask(task)
    }

    suspend fun deleteTask(task:ListItems){
        dao.deleteTask(task)
    }

    suspend fun updateTask(task:ListItems){
        dao.updateTask(task)
    }
}