package com.gorauskas.euler

interface EulerSolution {
    fun solve(): Double
    val problem: String
    val answer: String
}

typealias IEuler = EulerSolution
