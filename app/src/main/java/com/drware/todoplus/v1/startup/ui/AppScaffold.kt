// AppScaffold.kt — 2025-08-12 00:25 PDT
package com.drware.todoplus.v1.startup.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.drware.todoplus.v1.startup.ui.screens.TodoMainScreen
import com.drware.todoplus.v1.startup.viewmodel.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold() {
    val todoViewModel: TodoViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("TodoPlus") })
        }
    ) { innerPadding ->
        TodoMainScreen(
            modifier = Modifier.padding(innerPadding),
            viewModel = todoViewModel
        )
    }
}
