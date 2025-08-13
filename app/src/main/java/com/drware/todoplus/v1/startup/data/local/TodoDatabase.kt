// TodoDatabase.kt — 2025-08-12 22:15
package com.drware.todoplus.v1.startup.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Todo::class], version = 1, exportSchema = false)
@TypeConverters(LocalDateConverter::class) // Registers converter globally
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}
