package com.gorauskas.euler.solutions.fifty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler50Test {
    @Test
    fun testSolve() {
        val e = Euler50()
        Assertions.assertEquals(997_651L, e.solve())
    }
}
