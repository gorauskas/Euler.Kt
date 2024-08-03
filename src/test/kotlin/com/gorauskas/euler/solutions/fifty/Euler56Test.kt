package com.gorauskas.euler.solutions.fifty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler56Test {
    @Test
    fun testSolve() {
        val e = Euler56()
        Assertions.assertEquals(972L, e.solve())
    }
}
