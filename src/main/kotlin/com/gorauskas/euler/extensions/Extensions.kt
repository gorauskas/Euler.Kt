package com.gorauskas.euler.extensions

import com.gorauskas.euler.EULER_CHAR_OFFSET_64
import com.gorauskas.euler.exceptions.EulerResourceException
import java.io.IOException
import java.math.BigInteger
import java.net.URI
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.math.sqrt

fun Long.isPrime(): Boolean {
    if (this <= 1L) return false
    for (i in 2L..sqrt(this.toDouble()).toLong()) {
        if (this % i == 0L) return false
    }
    return true
}

fun Long.isPalindrome(): Boolean = this.toString() == this.toString().reversed()

fun Long.gcd(i: Long): Long = if (i == 0L) this else i.gcd(this % i)

fun Long.isMultipleOf(multiple: Long): Boolean = if (this == 0L || multiple == 0L) false else this % multiple == 0L

fun Long.divisors(): List<Long> {
    val factors = mutableSetOf<Long>()
    (1L..sqrt(this.toDouble()).toLong() + 1L)
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

fun Long.factors(): List<Long> = (1L..sqrt(this.toDouble()).toLong())
    .flatMap { i ->
        if (this % i == 0L) {
            if (i == this / i) {
                listOf(i)
            } else {
                listOf(i, this / i)
            }
        } else {
            emptyList()
        }
    }.sorted()

fun Long.primeFactors(): List<Long> = this.factors().filter { it.isPrime() }

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
    .minus(this.toString().map { it.digitToInt() }.toSet())
    .isEmpty()

fun Long.sorted(): String = toString().sorted()

@Suppress("MagicNumber")
fun Long.isPentagonal() = ((sqrt(24.0 * this + 1) + 1) / 6.0) % 1.0 == 0.0

fun String.sorted(): String = toCharArray().sorted().joinToString("")

fun String.longLength() = this.length.toLong()

fun String.toScore(): Long = toCharArray().sumOf { it.code - EULER_CHAR_OFFSET_64 }.toLong()

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
