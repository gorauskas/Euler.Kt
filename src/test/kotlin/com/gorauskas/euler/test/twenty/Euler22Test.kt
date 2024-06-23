package com.gorauskas.euler.test.twentyonetothirty

import com.gorauskas.euler.solutions.twenty.Euler22
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler22Test {
    @Test
    fun testSolve() {
        val e = Euler22()
        Assertions.assertEquals(871_198_282L, e.solve())
    }
}
