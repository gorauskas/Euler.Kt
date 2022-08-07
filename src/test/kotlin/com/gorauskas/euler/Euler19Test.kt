package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler19
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler19Test {

    @Test
    fun testSolve() {
        val e = Euler19()
        Assertions.assertEquals(171.0, e.solve())
    }

}
