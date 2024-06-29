package com.gorauskas.euler.test.one

import com.gorauskas.euler.solutions.one.Euler2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Euler2Test {
    @Test
    fun testSolve() {
        val e = Euler2()
        assertEquals(4_613_732L, e.solve())
    }
}
