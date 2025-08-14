package com.drware.todoplus.v1.startup.data.model

import java.time.LocalDateTime

/**
 * Core Todo item class.
 */
data class Todo(
    val id: Int,
    var category: String,
    var subCategory: String? = null,
    var title: String,
    var description: String? = null,
    val dateCreated: LocalDateTime = LocalDateTime.now(),
    var dateDue: LocalDateTime? = null,
    var recurrence: RecurrenceInfo? = null,
    var reminders: List<Reminder> = emptyList()
)