package com.example.navdrawer

import org.junit.Assert.*
import org.junit.Test

class UtilTestTest{

    @Test
    fun `checkEmptyUsername`() {

        val result = UtilTest.validateInput(
               "",
               "1234",
               "1234"
        )
        assertEquals("Admin", "")
    }

    @Test
    fun `ValidateUsername`() {

        val result = UtilTest.validateInput(
                "admins",
                "1234",
                "1234"
        )
        assertEquals("Admin", "admins")
        assertEquals("Admin", "admin")
    }

}