// TodoViewModel.kt — 2025-08-12 02:00 PDT
// ViewModel to manage UI-related data for Todo list with Room persistence.

package com.drware.todoplus.v1.startup.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.drware.todoplus.v1.startup.data.local.Todo
import com.drware.todoplus.v1.startup.data.local.TodoDatabase
import com.drware.todoplus.v1.startup.data.repository.TodoRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val todoDao = TodoDatabase.getInstance(application).todoDao()
    private val repository = TodoRepository(todoDao)

    val todos: StateFlow<List<Todo>> = repository.getTodos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addTodo(todo: Todo) = viewModelScope.launch { repository.addTodo(todo) }

    fun updateTodo(todo: Todo) = viewModelScope.launch { repository.updateTodo(todo) }

    fun deleteTodo(todo: Todo) = viewModelScope.launch { repository.deleteTodo(todo) }

    fun deleteTodoById(id: Long) = viewModelScope.launch { repository.deleteTodoById(id) }
}
