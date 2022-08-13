package com.gorauskas.euler

interface EulerSolution {
    fun solve(): Long
    val problem: String
    val answer: String
}

typealias IEuler = EulerSolution
