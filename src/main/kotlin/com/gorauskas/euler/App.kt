package com.gorauskas.euler

import com.github.ajalt.clikt.core.BadParameterValue
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.IncorrectArgumentValueCount
import com.github.ajalt.clikt.core.IncorrectOptionValueCount
import com.github.ajalt.clikt.core.MissingArgument
import com.github.ajalt.clikt.core.MissingOption
import com.github.ajalt.clikt.core.NoSuchOption
import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.versionOption
import com.github.ajalt.clikt.parameters.types.int
import com.gorauskas.euler.exceptions.EulerProblemException
import com.gorauskas.euler.functions.resolvePackage
import java.lang.reflect.InvocationTargetException

private const val EULER_PACKAGE = "com.gorauskas.euler.solutions."
private const val EULER_CLASS = "Euler"

class Euler : CliktCommand(help = "Project euler solutions written in Kotlin") {
    val problem: Int by option(
        "-p",
        "--problem",
        help = "Specify the problem/solution number you want to run",
    ).int().default(0)

    val verbose: Boolean by option(
        "-v",
        "--verbose",
        help = "Verbose outputs the problem statement and the solution",
    ).flag()

    init {
        versionOption(
            "1.2.0",
            names = setOf("-V", "--version"),
            message = { "Euler.Kt - version $it" },
        )
    }

    @Suppress("TooGenericExceptionCaught")
    override fun run() {
        try {
            val classLoader = this.javaClass.classLoader
            val euler = classLoader
                .loadClass(EULER_PACKAGE + resolvePackage(problem) + EULER_CLASS + problem)
                .getDeclaredConstructor()
                .newInstance() as EulerSolution
            if (verbose) {
                echo(euler.problem)
            }
            echo(euler.answer)
        } catch (exception: Exception) {
            when (exception) {
                is NoSuchMethodException,
                is InvocationTargetException,
                is ClassNotFoundException,
                is InstantiationException,
                is IllegalAccessException,
                -> {
                    echo("Unable to load Euler Problem class", err = true)
                    echo("Enter java -jar euler.jar -h for usage information", err = true)
                    throw EulerProblemException(problem, exception)
                }
                is BadParameterValue,
                is MissingOption,
                is MissingArgument,
                is NoSuchOption,
                is IncorrectArgumentValueCount,
                is IncorrectOptionValueCount,
                is UsageError,
                -> {
                    echo("Unable to parse command line parameters", err = true)
                    echo("Enter java -jar euler.jar -h for usage information", err = true)
                    System.exit(1)
                }
            }
        }
    }
}

fun main(args: Array<String>) = Euler().main(args)
