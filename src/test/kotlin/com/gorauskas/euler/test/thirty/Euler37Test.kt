package com.gorauskas.euler.test.thirtyonetoforty

import com.gorauskas.euler.solutions.thirty.Euler37
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler37Test {
    @Test
    fun testSolve() {
        val e = Euler37()
        Assertions.assertEquals(748_317L, e.solve())
    }
}
