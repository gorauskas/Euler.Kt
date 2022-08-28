package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler33
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler33Test {
    @Test
    fun testSolve() {
        val e = Euler33()
        Assertions.assertEquals(100L, e.solve())
    }
}
