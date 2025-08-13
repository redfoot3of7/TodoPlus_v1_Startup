// AppWithBiometricAuth.kt — 2025-08-05 16:40
package com.drware.todoplus.v1.startup.data.screens

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.drware.todoplus.v1.startup.viewmodel.TodoViewModel

/**
 * Entry screen that performs biometric authentication before showing the main app content.
 * If authentication succeeds, the onSuccess() callback triggers the rest of the UI.
 */
@Composable
fun AppWithBiometricAuth(
    viewModel: TodoViewModel,
    onSuccess: () -> Unit,
    onHelpClick: () -> Unit
) {
    val context = LocalContext.current
    val biometricManager = BiometricManager.from(context)

    val executor = ContextCompat.getMainExecutor(context)

    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Authenticate")
        .setSubtitle("Use biometric authentication to continue")
        .setNegativeButtonText("Cancel")
        .build()

    val biometricPrompt = BiometricPrompt(
        FragmentActivity(), // You may need to pass correct activity reference
        executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                onSuccess()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                // You could add a callback or toast here if needed
            }

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                // Consider showing help or fallback
                onHelpClick()
            }
        }
    )

    // Automatically trigger biometric prompt when composable enters
    LaunchedEffect(Unit) {
        biometricPrompt.authenticate(promptInfo)
    }
}

