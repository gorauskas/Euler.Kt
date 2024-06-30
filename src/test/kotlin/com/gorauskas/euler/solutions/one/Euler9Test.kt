package com.gorauskas.euler.solutions.one

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler9Test {
    @Test
    fun testSolve() {
        val e = Euler9()
        Assertions.assertEquals(31_875_000L, e.solve())
    }
}
