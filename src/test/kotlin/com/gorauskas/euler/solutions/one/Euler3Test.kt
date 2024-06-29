package com.gorauskas.euler.solutions.one

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler3Test {
    @Test
    fun testSolve() {
        val e = Euler3()
        Assertions.assertEquals(6_857L, e.solve())
    }
}
