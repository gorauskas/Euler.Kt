package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Euler1Test {

    @Test
    fun testSolve() {

        val e = Euler1()
        assertEquals(233168.0, e.solve())

    }

}
