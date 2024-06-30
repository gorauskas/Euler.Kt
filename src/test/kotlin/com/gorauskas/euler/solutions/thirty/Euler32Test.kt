package com.gorauskas.euler.solutions.thirty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler32Test {
    @Test
    fun testSolve() {
        val e = Euler32()
        Assertions.assertEquals(45_228L, e.solve())
    }
}
