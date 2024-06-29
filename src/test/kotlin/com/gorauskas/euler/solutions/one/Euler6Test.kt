package com.gorauskas.euler.test.one

import com.gorauskas.euler.solutions.one.Euler6
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler6Test {
    @Test
    fun testSolve() {
        val e = Euler6()
        Assertions.assertEquals(25_164_150L, e.solve())
    }
}
