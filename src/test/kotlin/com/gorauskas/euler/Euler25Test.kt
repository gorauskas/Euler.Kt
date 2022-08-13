package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler25
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler25Test {

    @Test
    fun testSolve() {
        val e = Euler25()
        Assertions.assertEquals(4782L, e.solve())
    }

}
