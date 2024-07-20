package com.gorauskas.euler.solutions.fifty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler53Test {
    @Test
    fun testSolve() {
        val e = Euler53()
        Assertions.assertEquals(4_075L, e.solve())
    }
}
