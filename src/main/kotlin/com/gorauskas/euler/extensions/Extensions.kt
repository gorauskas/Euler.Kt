package com.gorauskas.euler.extensions

import com.gorauskas.euler.exceptions.EulerResourceException
import java.io.IOException
import java.math.BigInteger
import java.net.URI
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

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

fun Long.isPalindrome(): Boolean = this.toString().equals(this.toString().reversed())

fun Long.gcd(i: Long): Long = if (i == 0L) this else i.gcd(this % i)

fun Long.isMultipleOf(multiple: Long): Boolean = if (this == 0L || multiple == 0L) false else this % multiple == 0L

fun Long.divisors(): List<Long> {
    val factors = mutableSetOf<Long>()
    (1L..Math.sqrt(this.toDouble()).toLong() + 1L)
        .map {
            if (this.isMultipleOf(it)) {
                factors.add(it)
                factors.add(this / it)
            }
        }
    return factors.toList()
}

fun Long.numberOfDivisors(): Long {
    if (this == 1L) return this
    return this.divisors().count().toLong()
}

fun Long.factorial(): Long = when {
    this < 0L -> throw IllegalArgumentException("negative number")
    this < 2L -> 1L
    else -> this * (this - 1L).factorial()
}

fun Double.factorial(): Double = when {
    this < 0.0 -> throw IllegalArgumentException("negative number")
    this < 2.0 -> 1.0
    else -> this * (this - 1.0).factorial()
}

fun BigInteger.factorial(): BigInteger {
    var f = BigInteger.ONE

    for (i in this.longValueExact() downTo 2) {
        f = f.multiply(BigInteger.valueOf(i))
    }

    return f
}

fun Long.sumOfDivisors(): Long = this.divisors().filter { it != this }.sum()

fun Long.isPanDigital(length: Int = 9): Boolean = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    .take(length)
    .minus(this.toString().map { it.digitToInt() })
    .isEmpty()

fun String.longLength() = this.length.toLong()

fun URI.getData(): String? {
    var path: Path? = null
    return try {
        path = if (this.toString().contains("!")) {
            val p = this.toString().split("!").toTypedArray()
            val fs = FileSystems.newFileSystem(URI.create(p[0]), HashMap<String, String>())
            fs.getPath(p[1])
        } else {
            Paths.get(this)
        }
        Files.readAllLines(path).joinToString("\n")
    } catch (e: IOException) {
        throw EulerResourceException(path?.toUri()!!, e)
    }
}
