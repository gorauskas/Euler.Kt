package com.gorauskas.euler.test.twentyonetothirty

import com.gorauskas.euler.solutions.twentyonetothirty.Euler26
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler26Test {
    @Test
    fun testSolve() {
        val e = Euler26()
        Assertions.assertEquals(983L, e.solve())
    }
}
