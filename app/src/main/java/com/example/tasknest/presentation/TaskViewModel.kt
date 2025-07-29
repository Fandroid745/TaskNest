package com.example.tasknest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(private val
                    repository:TaskRepository): ViewModel()
{
    val tasks= repository.task
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),emptyList())


    fun addTask(task:ListItems){
        viewModelScope.launch{
            repository.addTask(task)
        }
    }


    fun deleteTask(task:ListItems){
        viewModelScope.launch{
            repository.deleteTask(task)
        }
    }
}