// SortDropdown.kt — 2025-08-04 16:40
package com.drware.todoplus.v1.startup.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drware.todoplus.v1.startup.util.SortOption

/**
 * A dropdown menu UI to allow user to choose how to sort the todo list.
 */
@Composable
fun SortDropdown(
    selectedOption: SortOption,
    onOptionSelected: (SortOption) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text("Sort by", style = MaterialTheme.typography.labelMedium)

        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text(selectedOption.label)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                SortOption.values().forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option.label) },
                        onClick = {
                            onOptionSelected(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
