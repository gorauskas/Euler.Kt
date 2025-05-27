package com.gorauskas.euler.solutions.sixty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler63Test {
    @Test
    fun testSolve() {
        val e = Euler63()
        Assertions.assertEquals(49L, e.solve())
    }
}
