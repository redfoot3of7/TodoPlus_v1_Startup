}// RecurrenceInfo.kt — 2025-08-13 16:10
package com.drware.todoplus.v1.startup.data.model

import java.time.DayOfWeek

/**
 * Recurrence information for a Todo item.
 */
data class RecurrenceInfo(
    val frequency: Frequency,
    val interval: Int = 1,        // e.g., every 2 days/weeks/months
    val dayOfWeek: DayOfWeek? = null,
    val dayOfMonth: Int? = null,  // e.g., 2nd Thursday
    val monthOfYear: Int? = null
) {
    enum class Frequency {
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY,
        CUSTOM
    }
}
