package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler6
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler6Test {
    @Test
    fun testSolve() {
        val e = Euler6()
        Assertions.assertEquals(25164150L, e.solve())
    }
}
