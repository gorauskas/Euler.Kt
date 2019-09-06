package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Euler2Test {

    @Test
    fun testSolve() {

        val e = Euler2()
        assertEquals(4613732.0, e.solve())

    }

}