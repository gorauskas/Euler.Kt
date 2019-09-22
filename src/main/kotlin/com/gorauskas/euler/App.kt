package com.gorauskas.euler

import com.github.ajalt.clikt.core.*
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.versionOption
import com.github.ajalt.clikt.parameters.types.int
import java.lang.reflect.InvocationTargetException

private const val EULER_PACKAGE = "com.gorauskas.euler.solutions."
private const val EULER_CLASS = "Euler"

class Euler : CliktCommand() {

    val problem: Int by option("-p", "--problem",
        help = "Specify the problem/solution number you want to run")
        .int()
        .default(0)

    val verbose: Boolean by option("-v", "--verbose",
        help = "Verbose outputs the problem statement and the solution")
        .flag()

    init {

        versionOption("0.1.0",
            names = setOf("-V", "--version"),
            message = { "Euler.Kt - version $it" })

    }

    override fun run() {

        try {

            val cl = this.javaClass.classLoader
            val e = cl.loadClass(EULER_PACKAGE + EULER_CLASS + problem)
                .getDeclaredConstructor()
                .newInstance() as EulerInterface

            if (verbose) {
                echo(e.problem)
            }

            echo(e.answer)

        } catch (e: Exception) {

            when (e) {

                is NoSuchMethodException,
                is InvocationTargetException,
                is ClassNotFoundException,
                is InstantiationException,
                is IllegalAccessException -> {
                    echo("Unable to load Euler Problem class", err = true)
                    echo("Enter java -jar euler.jar -h for usage information", err = true)
                    System.exit(1);
                }

                is UsageError,
                is BadParameterValue,
                is MissingParameter,
                is NoSuchOption,
                is IncorrectArgumentValueCount,
                is IncorrectOptionValueCount -> {
                    echo("Unable to parse command line parameters", err = true)
                    echo("Enter java -jar euler.jar -h for usage information", err = true)
                    System.exit(1);
                }

            }

        }

    }

}

fun main(args: Array<String>) = Euler().main(args)
