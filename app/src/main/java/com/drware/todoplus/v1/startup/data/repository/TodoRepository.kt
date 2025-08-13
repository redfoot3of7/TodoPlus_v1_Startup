// TodoRepository.kt — 2025-08-12 02:00 PDT
// Repository layer providing data operations to ViewModel, abstracting data source.

package com.drware.todoplus.v1.startup.data.repository

import com.drware.todoplus.v1.startup.data.local.Todo
import com.drware.todoplus.v1.startup.data.local.TodoDao
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {

    fun getTodos(): Flow<List<Todo>> = todoDao.getAllTodos()

    suspend fun addTodo(todo: Todo) = todoDao.insert(todo)

    suspend fun updateTodo(todo: Todo) = todoDao.update(todo)

    suspend fun deleteTodo(todo: Todo) = todoDao.delete(todo)

    suspend fun deleteTodoById(id: Long) = todoDao.deleteById(id)
}
