package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler29
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler29Test {

    @Test
    fun testSolve() {
        val e = Euler29()
        Assertions.assertEquals(9183.0, e.solve())
    }

}
