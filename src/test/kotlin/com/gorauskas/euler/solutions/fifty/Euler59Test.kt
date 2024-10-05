package com.gorauskas.euler.solutions.fifty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler59Test {
    @Test
    fun testSolve() {
        val e = Euler59()
        Assertions.assertEquals(129_448L, e.solve())
    }
}
