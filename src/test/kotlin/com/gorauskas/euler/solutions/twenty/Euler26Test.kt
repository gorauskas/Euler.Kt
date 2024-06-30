package com.gorauskas.euler.solutions.twenty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler26Test {
    @Test
    fun testSolve() {
        val e = Euler26()
        Assertions.assertEquals(983L, e.solve())
    }
}
