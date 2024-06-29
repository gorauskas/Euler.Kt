package com.gorauskas.euler.solutions.twenty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler29Test {
    @Test
    fun testSolve() {
        val e = Euler29()
        Assertions.assertEquals(9_183L, e.solve())
    }
}
