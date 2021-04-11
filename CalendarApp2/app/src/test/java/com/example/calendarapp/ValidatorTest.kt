package com.example.calendarapp

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest{

    @Test
    fun eventInputIsValid() {
        val description = "Example Event"   // unit test that the component is able to accept
        val result = Validator.validateEventDescription(description)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun eventInputIsInvalid() {  // FIXME
        val description = ""    // if user does not input anything into event description it should fail
        val result = Validator.validateEventDescription(description)
        assertThat(result).isEqualTo(false) // this fails, check for isEmpty() not null
    }

    @Test
    fun dateIsNumber() {    // TODO
        val eventDate = "4/11/2021" // see how SQLite database stores date on calendar widget
        val result = Validator.validateEventDate(eventDate)
        assertThat(result).isEqualTo(true)
    }
}