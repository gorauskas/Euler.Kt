package com.gorauskas.euler.test.twentyonetothirty

import com.gorauskas.euler.solutions.twentyonetothirty.Euler22
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler22Test {
    @Test
    fun testSolve() {
        val e = Euler22()
        Assertions.assertEquals(871_198_282L, e.solve())
    }
}
