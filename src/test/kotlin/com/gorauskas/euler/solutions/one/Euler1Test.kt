package com.gorauskas.euler.test.one

import com.gorauskas.euler.solutions.one.Euler1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Euler1Test {
    @Test
    fun testSolve() {
        val e = Euler1()
        assertEquals(233_168L, e.solve())
    }
}
