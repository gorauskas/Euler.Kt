package com.gorauskas.euler.solutions.ten

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler16Test {
    @Test
    fun testSolve() {
        val e = Euler16()
        Assertions.assertEquals(1_366L, e.solve())
    }
}
