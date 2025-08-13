// BiometricStatus.kt — 2025-08-07 10:52
package com.drware.todoplus.v1.startup.model

// Enum representing the current status of biometric availability
enum class BiometricStatus {
    AVAILABLE,
    NO_HARDWARE,
    HARDWARE_UNAVAILABLE,
    NONE_ENROLLED,
    UNKNOWN
}
