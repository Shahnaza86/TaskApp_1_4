package com.example.taskapp_1_4.data.local.db

import androidx.room.*
import com.example.taskapp_1_4.model.Task

@Dao
interface TaskDao {
    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)


    @Query("SELECT * FROM task ORDER BY id DESC")
    fun getAll(): List<Task>

}