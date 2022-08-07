package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler24
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler24Test {

    @Test
    fun testSolve() {
        val e = Euler24()
        Assertions.assertEquals(2783915460.0, e.solve())
    }

}
