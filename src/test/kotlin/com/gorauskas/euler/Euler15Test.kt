package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler15
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler15Test {

    @Test
    fun testSolve() {
        val e = Euler15()
        Assertions.assertEquals(137846528820.0, e.solve())
    }

}