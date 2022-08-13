package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler3
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler3Test {
    @Test
    fun testSolve() {
        val e = Euler3()
        Assertions.assertEquals(6857L, e.solve())
    }
}
