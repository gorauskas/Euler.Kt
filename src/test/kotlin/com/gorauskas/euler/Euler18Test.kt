package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler18
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler18Test {

    @Test
    fun testSolve() {
        val e = Euler18()
        Assertions.assertEquals(1074.0, e.solve())
    }

}
