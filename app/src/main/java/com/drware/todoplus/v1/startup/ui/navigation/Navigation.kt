// Navigation.kt — 2025-08-09
package com.drware.todoplus.v1.startup.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.drware.todoplus.v1.startup.ui.screens.TodoMainScreen
import com.drware.todoplus.v1.startup.viewmodel.TodoViewModel

@Composable
fun AppNavigation(navController: NavHostController, todoViewModel: TodoViewModel) {
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            TodoMainScreen(todoViewModel)
        }
    }
}
