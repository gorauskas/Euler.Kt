package com.gorauskas.euler.solutions.one

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Euler1Test {
    @Test
    fun testSolve() {
        val e = Euler1()
        assertEquals(233_168L, e.solve())
    }
}
