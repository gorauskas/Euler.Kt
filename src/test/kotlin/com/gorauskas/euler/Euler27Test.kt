package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler27
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler27Test {

    @Test
    fun testSolve() {
        val e = Euler27()
        Assertions.assertEquals(-59231L, e.solve())
    }

}
