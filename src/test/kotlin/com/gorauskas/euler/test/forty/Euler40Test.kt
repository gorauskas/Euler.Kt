package com.gorauskas.euler.test.thirtyonetoforty

import com.gorauskas.euler.solutions.forty.Euler40
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler40Test {
    @Test
    fun testSolve() {
        val e = Euler40()
        Assertions.assertEquals(210L, e.solve())
    }
}
