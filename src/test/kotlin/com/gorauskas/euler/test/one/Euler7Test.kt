package com.gorauskas.euler.test.one

import com.gorauskas.euler.solutions.one.Euler7
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler7Test {
    @Test
    fun testSolve() {
        val e = Euler7()
        Assertions.assertEquals(104_743L, e.solve())
    }
}