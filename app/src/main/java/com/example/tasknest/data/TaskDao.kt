package com.example.tasknest

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao{
    @Query("SELECT*From tasks")
    fun getTasks():Flow<List<ListItems>>


    @Upsert
    suspend fun addTask(task:ListItems)

    @Delete
    suspend fun deleteTask(task:ListItems)


    @Update
    suspend fun updateTask(task:ListItems)


}