package com.gorauskas.euler.solutions.thirty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler36Test {
    @Test
    fun testSolve() {
        val e = Euler36()
        Assertions.assertEquals(872_187L, e.solve())
    }
}
