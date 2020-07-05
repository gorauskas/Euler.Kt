package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler16
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler16Test {

    @Test
    fun testSolve() {
        val e = Euler16()
        Assertions.assertEquals(1366.0, e.solve())
    }

}