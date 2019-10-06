package com.gorauskas.euler.extensions

import java.lang.StringBuilder

fun Long.isPrime(): Boolean {
    if (this and 1 == 0L) {
        return this == 2L
    }

    var k = 3L
    while (k * k <= this) {
        if (this % k == 0L) {
            return false
        }
        k += 2
    }

    return this != 1L
}

fun Long.isPalindrome(): Boolean {
    return this.toString().equals(
        StringBuilder().append(this.toString()).reverse().toString()
    )
}

fun Long.gcd(i: Long): Long {
    return if (i == 0L) this else i.gcd(this % i)
}

fun Long.isMultipleOf(multiple: Long): Boolean {
    return if (this == 0L || multiple == 0L) false else this % multiple == 0L
}

fun Long.numberOfDivisors(): Long {
    if (this == 1L)
        return this

    return (1L..Math.sqrt(this.toDouble()).toLong())
        .filter { this.isMultipleOf(it) }
        .count() * 2L
}
