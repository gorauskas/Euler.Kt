package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler14
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler14Test {

    @Test
    fun testSolve() {
        val e = Euler14()
        Assertions.assertEquals(837799.0, e.solve())
    }

}