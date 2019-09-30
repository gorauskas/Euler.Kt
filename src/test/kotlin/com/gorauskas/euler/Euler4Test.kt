package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler4
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Euler4Test {

    @Test
    fun testSolve() {

        val e = Euler4()
        assertEquals(906609.0, e.solve())

    }
}