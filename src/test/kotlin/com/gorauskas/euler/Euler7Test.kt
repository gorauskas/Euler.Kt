package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler7
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler7Test {
    @Test
    fun testSolve() {
        val e = Euler7()
        Assertions.assertEquals(104743L, e.solve())
    }
}
