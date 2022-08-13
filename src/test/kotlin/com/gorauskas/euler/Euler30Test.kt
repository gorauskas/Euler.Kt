package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler30
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler30Test {

    @Test
    fun testSolve() {
        val e = Euler30()
        Assertions.assertEquals(443839L, e.solve())
    }

}
