package com.gorauskas.euler.solutions.fifty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler52Test {
    @Test
    fun testSolve() {
        val e = Euler52()
        Assertions.assertEquals(142_857L, e.solve())
    }
}
