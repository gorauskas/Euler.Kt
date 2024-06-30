package com.gorauskas.euler.solutions.forty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler42Test {
    @Test
    fun testSolve() {
        val e = Euler42()
        Assertions.assertEquals(162L, e.solve())
    }
}
