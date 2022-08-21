package com.gorauskas.euler.exceptions

class EulerProblemException(problem: Int, e: Exception) : Exception("Unable to load Euler Problem $problem class", e)
