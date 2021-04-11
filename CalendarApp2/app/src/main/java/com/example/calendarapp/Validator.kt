package com.example.calendarapp

import androidx.core.text.isDigitsOnly

object Validator {
    fun validateEventDescription(eventDescription: String): Boolean {
        return eventDescription != null  // consider switching to isEmpty()
        // issue with Kotlin and JDK 14 - stdlib unable to access
    }

    // TODO
    fun validateEventDate(date: String): Boolean {
        return date.isDigitsOnly()
    }
}