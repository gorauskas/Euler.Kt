package com.gorauskas.euler.test.twentyonetothirty

import com.gorauskas.euler.solutions.twentyonetothirty.Euler21
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler21Test {
    @Test
    fun testSolve() {
        val e = Euler21()
        Assertions.assertEquals(31_626L, e.solve())
    }
}
