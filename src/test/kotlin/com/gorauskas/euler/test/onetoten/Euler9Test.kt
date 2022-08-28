package com.gorauskas.euler.test.onetoten

import com.gorauskas.euler.solutions.onetoten.Euler9
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler9Test {
    @Test
    fun testSolve() {
        val e = Euler9()
        Assertions.assertEquals(31_875_000L, e.solve())
    }
}
