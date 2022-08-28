package com.gorauskas.euler.test.thirtyonetoforty

import com.gorauskas.euler.solutions.thirtyonetoforty.Euler33
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler33Test {
    @Test
    fun testSolve() {
        val e = Euler33()
        Assertions.assertEquals(100L, e.solve())
    }
}
