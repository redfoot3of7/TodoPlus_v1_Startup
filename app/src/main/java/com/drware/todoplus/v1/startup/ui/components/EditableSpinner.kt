// EditableSpinner.kt — 2025-08-04 18:55
@file:OptIn(ExperimentalMaterial3Api::class)

package com.drware.todoplus.v1.startup.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A dropdown spinner with preset options and the ability to add/edit custom options.
 *
 * @param label The label for the dropdown field
 * @param options List of current options to select from
 * @param selectedOption Currently selected option
 * @param onOptionSelected Callback when option is selected
 * @param onAddOption Callback when user adds a new option (returns new option string)
 */
@Composable
fun EditableSpinner(
    label: String,
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit,
    onAddOption: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var showAddDialog by remember { mutableStateOf(false) }
    var newOptionText by remember { mutableStateOf("") }

    Column {
        Text(text = label, style = MaterialTheme.typography.labelMedium)

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                readOnly = true,
                value = selectedOption ?: "",
                onValueChange = {},
                label = { Text(label) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            onOptionSelected(option)
                            expanded = false
                        }
                    )
                }
                Divider()
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Add, contentDescription = "Add new")
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Add new...")
                        }
                    },
                    onClick = {
                        expanded = false
                        showAddDialog = true
                        newOptionText = ""
                    }
                )
            }
        }
    }

    if (showAddDialog) {
        AlertDialog(
            onDismissRequest = { showAddDialog = false },
            title = { Text("Add new $label") },
            text = {
                OutlinedTextField(
                    value = newOptionText,
                    onValueChange = { newOptionText = it },
                    label = { Text("New $label") },
                    singleLine = true
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (newOptionText.isNotBlank()) {
                            onAddOption(newOptionText.trim())
                            onOptionSelected(newOptionText.trim())
                            showAddDialog = false
                        }
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAddDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}


