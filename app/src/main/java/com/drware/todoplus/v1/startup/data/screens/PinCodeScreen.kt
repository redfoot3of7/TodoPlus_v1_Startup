// PinCodeScreen.kt — 2025-08-04 17:38 PDT
// PIN entry fallback UI for manual authentication in place of biometric access.

package com.drware.todoplus.v1.startup.data.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast

@Composable
fun PinCodeScreen(
    correctPin: String = "1234", // In production, never hardcode! Use encrypted storage.
    onAuthenticated: () -> Unit,
    onCancel: () -> Unit
) {
    var enteredPin by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter PIN", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = enteredPin,
            onValueChange = {
                if (it.length <= 4 && it.all { char -> char.isDigit() }) {
                    enteredPin = it
                    errorMessage = null
                }
            },
            label = { Text("4-digit PIN") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = {
                if (enteredPin == correctPin) {
                    Toast.makeText(context, "Access granted", Toast.LENGTH_SHORT).show()
                    onAuthenticated()
                } else {
                    errorMessage = "Incorrect PIN. Try again."
                }
            }) {
                Text("Submit")
            }

            OutlinedButton(onClick = { onCancel() }) {
                Text("Cancel")
            }
        }
    }
}
