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
