// TodoMainScreen.kt — 2025-08-12 02:00 PDT
// Main Composable screen showing the list of todos and an add button.

package com.drware.todoplus.v1.startup.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drware.todoplus.v1.startup.data.local.Todo
import com.drware.todoplus.v1.startup.viewmodel.TodoViewModel

@Composable
fun TodoMainScreen(
    modifier: Modifier = Modifier,
    todoViewModel: TodoViewModel
) {
    val todos by todoViewModel.todos.collectAsState()

    Column(modifier = modifier.padding(16.dp)) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(todos) { todo ->
                Text(todo.title)
                Spacer(Modifier.height(8.dp))
            }
        }
        Button(onClick = {
            todoViewModel.addTodo(
                Todo(title = "New task at ${System.currentTimeMillis()}")
            )
        }) {
            Text("Add Todo")
        }
    }
}
