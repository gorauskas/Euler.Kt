package com.gorauskas.euler.solutions.fifty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler55Test {
    @Test
    fun testSolve() {
        val e = Euler55()
        Assertions.assertEquals(249L, e.solve())
    }
}
