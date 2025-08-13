// PersistenceHelper.kt — 2025-08-04 16:55
package com.drware.todoplus.v1.startup.util

import android.content.Context
import com.drware.todoplus.v1.startup.data.local.Todo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

object PersistenceHelper {
    private const val FILENAME = "todos.json"

    fun saveTodos(context: Context, todos: List<Todo>) {
        val jsonString = Json.encodeToString(todos)
        context.openFileOutput(FILENAME, Context.MODE_PRIVATE).use {
            it.write(jsonString.toByteArray())
        }
    }

    fun loadTodos(context: Context): List<Todo> {
        val file = File(context.filesDir, FILENAME)
        if (!file.exists()) return emptyList()
        return file.readText().let { Json.decodeFromString(it) }
    }
}
