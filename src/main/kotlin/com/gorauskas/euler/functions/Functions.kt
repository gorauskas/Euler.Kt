package com.gorauskas.euler.functions

/**
 * Executes the given [fn] and displays elapsed time in milliseconds.
 */
inline fun <T> timer(display: Boolean? = true, fn: () -> T): T {
    val start = System.currentTimeMillis()
    val result: T = fn.invoke()
    val end = System.currentTimeMillis()
    if (display == true) println("Executed in ${end - start} milliseconds")
    return result
}

fun findPackage(problem: Int): String? =
    when (problem) {
        in (1..10) -> "onetoten."
        in (11..20) -> "eleventotwenty."
        in (21..30) -> "twentyonetothirty."
        in (31..40) -> "thirtyonetoforty."
        else -> null
    }
