package com.gorauskas.euler.solutions.fifty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler58Test {
    @Test
    fun testSolve() {
        val e = Euler58()
        Assertions.assertEquals(26_241L, e.solve())
    }
}
