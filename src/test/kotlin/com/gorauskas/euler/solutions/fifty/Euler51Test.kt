package com.gorauskas.euler.solutions.fifty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler51Test {
    @Test
    fun testSolve() {
        val e = Euler51()
        Assertions.assertEquals(121_313L, e.solve())
    }
}
