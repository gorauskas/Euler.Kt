package com.gorauskas.euler.test.ten

import com.gorauskas.euler.solutions.ten.Euler19
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler19Test {
    @Test
    fun testSolve() {
        val e = Euler19()
        Assertions.assertEquals(171L, e.solve())
    }
}
