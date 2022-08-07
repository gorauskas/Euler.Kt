package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler28
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler28Test {

    @Test
    fun testSolve() {
        val e = Euler28()
        Assertions.assertEquals(669171001.0, e.solve())
    }

}
