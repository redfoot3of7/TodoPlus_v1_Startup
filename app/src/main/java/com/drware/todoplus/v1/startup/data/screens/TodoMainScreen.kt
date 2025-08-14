// TodoMainScreen.kt — 2025-08-13 21:05 PDT
package com.drware.todoplus.v1.startup.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drware.todoplus.v1.startup.viewmodel.TodoViewModel

/**
 * Main screen for displaying and managing the todo list.
 * Accepts a TodoViewModel from the parent Composable.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoMainScreen(
    modifier: Modifier = Modifier,
    viewModel: TodoViewModel
) {
    // This column holds the list and input components
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Your Todo List",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Example placeholder for todo items list
        Text(
            text = "TODO: Display items here",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Example placeholder for add-task button
        Button(onClick = { /* TODO: Implement add task */ }) {
            Text("Add Task")
        }
    }
}
