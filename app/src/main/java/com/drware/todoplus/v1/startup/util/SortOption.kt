// SortOption.kt — 2025-08-04 16:41
package com.drware.todoplus.v1.startup.util

/**
 * Enum for sorting options available to the user.
 */
enum class SortOption(val label: String) {
    TITLE_ASCENDING("Title (A-Z)"),
    TITLE_DESCENDING("Title (Z-A)"),
    DATE_ASCENDING("Date (Earliest First)"),
    DATE_DESCENDING("Date (Latest First)")
}
