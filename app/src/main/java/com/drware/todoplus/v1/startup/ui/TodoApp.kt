package com.drware.todoplus.v1.startup.ui

import android.app.Application
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.drware.todoplus.v1.startup.ui.screens.TodoMainScreen
import com.drware.todoplus.v1.startup.viewmodel.TodoViewModel
import com.drware.todoplus.v1.startup.viewmodel.TodoViewModelFactory
import com.drware.todoplus.v1.startup.ui.theme.TodoPlusTheme

@Composable
fun TodoApp(application: Application) {
    val todoViewModel: TodoViewModel = viewModel(factory = TodoViewModelFactory(application))

    TodoPlusTheme {
        Surface {
            TodoMainScreen(
                viewModel = todoViewModel
            )
        }
    }
}
