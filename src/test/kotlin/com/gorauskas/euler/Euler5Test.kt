package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler5
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler5Test {

    @Test
    fun testSolve() {

        val e = Euler5()
        Assertions.assertEquals(232792560.0, e.solve())

    }

}