// BiometricAuthDialog.kt — 2025-08-07 10:33
// Provides biometric authentication UI and logic using BiometricPrompt.
// This file handles authentication lifecycle and error reporting.

package com.drware.todoplus.v1.startup.ui.components

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import java.util.concurrent.Executor

fun showBiometricPrompt(
    context: Context,
    title: String,
    subtitle: String,
    description: String,
    negativeButtonText: String,
    onAuthSuccess: () -> Unit,
    onAuthError: (String) -> Unit
) {
    val activity = context as? FragmentActivity
    if (activity == null) {
        onAuthError("Biometric prompt requires a FragmentActivity context.")
        return
    }

    val biometricManager = BiometricManager.from(context)
    if (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG) != BiometricManager.BIOMETRIC_SUCCESS) {
        onAuthError("Biometric authentication is not available or not set up.")
        return
    }

    val executor: Executor = ContextCompat.getMainExecutor(context)
    val biometricPrompt = BiometricPrompt(
        activity,
        executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                onAuthError("Authentication error: $errString")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                onAuthSuccess()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                onAuthError("Authentication failed.")
            }
        })

    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle(title)
        .setSubtitle(subtitle)
        .setDescription(description)
        .setNegativeButtonText(negativeButtonText)
        .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
        .build()

    biometricPrompt.authenticate(promptInfo)
}
