// Todo.kt — 2025-08-12 22:15
// Entity representing a Todo item in the database.

package com.drware.todoplus.v1.startup.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.time.LocalDate

@Entity(tableName = "todos")
@TypeConverters(LocalDateConverter::class) // <-- Tells Room to use our LocalDate converter
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String? = null,
    val dueDate: LocalDate? = null, // Room will store this using our converter
    val isDone: Boolean = false
)
