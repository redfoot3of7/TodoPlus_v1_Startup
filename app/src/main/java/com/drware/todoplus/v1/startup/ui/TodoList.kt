// TodoList.kt — 2025-08-07 15:40
package com.drware.todoplus.v1.startup.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drware.todoplus.v1.startup.data.local.Todo

@Composable
fun TodoList(
    todos: List<Todo>,
    onEditClick: (Todo) -> Unit,
    onDeleteClick: (Todo) -> Unit,
    onToggleDone: (Todo) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(todos) { todo ->
            TodoItem(
                todo = todo,
                onEditClick = { onEditClick(todo) },
                onDeleteClick = { onDeleteClick(todo) },
                onToggleDone = { onToggleDone(todo) }
            )
        }
    }
}

@Composable
fun TodoItem(
    todo: Todo,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onToggleDone: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = todo.title, style = MaterialTheme.typography.titleMedium)
                todo.dueDate?.let {
                    Text(text = "Due: $it", style = MaterialTheme.typography.bodySmall)
                }
            }
            Checkbox(
                checked = todo.completed,
                onCheckedChange = { onToggleDone() }
            )
            IconButton(onClick = onEditClick) {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit Todo")
            }
            IconButton(onClick = onDeleteClick) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Todo")
            }
        }
    }
}
