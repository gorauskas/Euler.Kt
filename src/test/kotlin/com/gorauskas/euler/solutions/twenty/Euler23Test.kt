package com.gorauskas.euler.solutions.twenty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler23Test {
    @Test
    fun testSolve() {
        val e = Euler23()
        Assertions.assertEquals(4_179_871L, e.solve())
    }
}
