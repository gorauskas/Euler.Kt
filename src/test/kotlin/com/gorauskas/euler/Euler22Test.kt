package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler22
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler22Test {

    @Test
    fun testSolve() {
        val e = Euler22()
        Assertions.assertEquals(871198282L, e.solve())
    }

}
