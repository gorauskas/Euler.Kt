package com.gorauskas.euler.solutions.sixty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler60Test {
    @Test
    fun testSolve() {
        val e = Euler60()
        Assertions.assertEquals(26_033L, e.solve())
    }
}
