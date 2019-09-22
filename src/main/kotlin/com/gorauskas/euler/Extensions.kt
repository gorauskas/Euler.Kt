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