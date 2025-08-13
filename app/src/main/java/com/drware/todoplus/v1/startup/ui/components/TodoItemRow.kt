// TodoItemRow.kt — 2025-08-06 10:22
// This file defines a composable that renders a single todo item in a row,
// including edit, delete, and toggle-done buttons.

package com.drware.todoplus.v1.startup.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drware.todoplus.v1.startup.data.local.Todo

@Composable
fun TodoItemRow(
    todo: Todo,
    onEditClick: (Todo) -> Unit,
    onDeleteClick: (Todo) -> Unit,
    onToggleDone: (Todo) -> Unit  // ✅ Added this
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onToggleDone(todo) },  // ✅ Make the row clickable for toggling
        colors = CardDefaults.cardColors(
            containerColor = if (todo.completed) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = todo.title,
                style = MaterialTheme.typography.bodyLarge,
                color = if (todo.completed) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.onSurface
            )
            Row {
                IconButton(onClick = { onToggleDone(todo) }) {
                    Icon(Icons.Default.Check, contentDescription = "Toggle Done")
                }
                IconButton(onClick = { onEditClick(todo) }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = { onDeleteClick(todo) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}
