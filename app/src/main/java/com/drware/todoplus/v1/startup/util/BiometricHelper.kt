// BiometricHelper.kt — 2025-08-07 12:45
package com.drware.todoplus.v1.startup.util

import android.content.Context
import android.os.Build
import androidx.biometric.BiometricManager

// A sealed class representing the possible biometric availability statuses.
sealed class BiometricStatus {
    data object Available : BiometricStatus()
    data object NoHardware : BiometricStatus()
    data object HardwareUnavailable : BiometricStatus()
    data object NoneEnrolled : BiometricStatus()
    data object SecurityUpdateRequired : BiometricStatus()
    data object Unsupported : BiometricStatus()
    data object Unknown : BiometricStatus()
}

// Returns a BiometricStatus based on the device's biometric capabilities.
fun getBiometricStatus(context: Context): BiometricStatus {
    val biometricManager = BiometricManager.from(context)

    return when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK)) {
        BiometricManager.BIOMETRIC_SUCCESS -> BiometricStatus.Available
        BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> BiometricStatus.NoHardware
        BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> BiometricStatus.HardwareUnavailable
        BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> BiometricStatus.NoneEnrolled
        BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> BiometricStatus.SecurityUpdateRequired
        BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> BiometricStatus.Unsupported
        else -> BiometricStatus.Unknown
    }
}
