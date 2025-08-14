// Reminder.kt — 2025-08-13 16:05
package com.drware.todoplus.v1.startup.data..model

import java.time.LocalDateTime

/**
 * Reminder for a Todo item.
 */
data class Reminder(
    val id: Int,
    val timeBefore: Long, // milliseconds before due date
    val message: String
)
