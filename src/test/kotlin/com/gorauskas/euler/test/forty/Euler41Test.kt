package com.gorauskas.euler.test.forty

import com.gorauskas.euler.solutions.forty.Euler41
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler41Test {
    @Test
    fun testSolve() {
        val e = Euler41()
        Assertions.assertEquals(7_652_413L, e.solve())
    }
}
