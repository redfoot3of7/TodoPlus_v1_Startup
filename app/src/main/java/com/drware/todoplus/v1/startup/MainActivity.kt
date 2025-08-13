// MainActivity.kt — 2025-08-11 23:10 PDT
// Entry point for the TodoPlus app, applies app-wide theme

package com.drware.todoplus.v1.startup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.drware.todoplus.v1.startup.ui.AppScaffold
import com.drware.todoplus.v1.startup.ui.theme.TodoPlusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoPlusTheme {
                AppScaffold()
            }
        }
    }
}
