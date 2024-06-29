package com.gorauskas.euler.solutions.one

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler6Test {
    @Test
    fun testSolve() {
        val e = Euler6()
        Assertions.assertEquals(25_164_150L, e.solve())
    }
}
