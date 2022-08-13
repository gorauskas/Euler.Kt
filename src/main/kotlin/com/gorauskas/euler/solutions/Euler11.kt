package com.gorauskas.euler.solutions

import com.gorauskas.euler.EULER11_MATRIX
import com.gorauskas.euler.EulerSolution

class Euler11 : EulerSolution {
    private var sm = StringMatrix(EULER11_MATRIX.trimIndent())

    override fun solve(): Double {
        return sm.product.toDouble()
    }

    override val problem = """
        Project Euler Problem 11:

            In the 20x20 grid below, four numbers along a diagonal line have been
            marked in red.

            $EULER11_MATRIX

            The product of these numbers is 26 x 63 x 78 x 14 = 1788696.

            What is the greatest product of four adjacent numbers in any direction
            (up, down, left, right, or diagonally) in the 20x20 grid?
    """.trimIndent()

    override val answer = """

        The greatest product of four adjacent numbers in the grid is:
        P: ${sm.product}; Loc: ${sm.x},${sm.y}; Seq: ${sm.sequence}
    """.trimIndent()

    enum class Orientation {
        Up, Down, Left, Right, UpLeft, UpRight, DownLeft, DownRight
    }

    internal inner class StringMatrix(matrix: String) {
        private val intMatrix = Array(20) { IntArray(20) }
        private var strMatrix = ""

        var product: Int = 0
            private set
        var x: Int = 0
            private set
        var y: Int = 0
            private set
        var sequence: List<Int>? = null
            private set

        init {
            this.strMatrix = matrix
            this.calculateIntMatrix()
            this.calculateGreatestProductOfFourAdjacentNumbers()
        }

        private fun getAdjacentList(orient: Orientation, x: Int, y: Int): List<Int> {
            val l = ArrayList<Int>()

            when (orient) {
                Orientation.Down -> {
                    l.add(intMatrix[y][x])
                    l.add(intMatrix[y + 1][x])
                    l.add(intMatrix[y + 2][x])
                    l.add(intMatrix[y + 3][x])
                }
                Orientation.DownLeft -> {
                    l.add(intMatrix[y][x])
                    l.add(intMatrix[y + 1][x - 1])
                    l.add(intMatrix[y + 2][x - 2])
                    l.add(intMatrix[y + 3][x - 3])
                }
                Orientation.DownRight -> {
                    l.add(intMatrix[y][x])
                    l.add(intMatrix[y + 1][x + 1])
                    l.add(intMatrix[y + 2][x + 2])
                    l.add(intMatrix[y + 3][x + 3])
                }
                Orientation.Left -> {
                    l.add(intMatrix[y][x])
                    l.add(intMatrix[y][x - 1])
                    l.add(intMatrix[y][x - 2])
                    l.add(intMatrix[y][x - 3])
                }
                Orientation.Right -> {
                    l.add(intMatrix[y][x])
                    l.add(intMatrix[y][x + 1])
                    l.add(intMatrix[y][x + 2])
                    l.add(intMatrix[y][x + 3])
                }
                Orientation.Up -> {
                    l.add(intMatrix[y][x])
                    l.add(intMatrix[y - 1][x])
                    l.add(intMatrix[y - 2][x])
                    l.add(intMatrix[y - 3][x])
                }
                Orientation.UpLeft -> {
                    l.add(intMatrix[y][x])
                    l.add(intMatrix[y - 1][x - 1])
                    l.add(intMatrix[y - 2][x - 2])
                    l.add(intMatrix[y - 3][x - 3])
                }
                Orientation.UpRight -> {
                    l.add(intMatrix[y][x])
                    l.add(intMatrix[y - 1][x + 1])
                    l.add(intMatrix[y - 2][x + 2])
                    l.add(intMatrix[y - 3][x + 3])
                }
            }

            return l
        }

        private fun calculateIntMatrix() {
            val numbers = strMatrix.split("[ \\n]".toRegex()).map { it.toInt() }
            var i = 0
            var j = 0

            numbers.forEach { number ->
                intMatrix[i][j] = number
                j++
                if (j == 20) {
                    j = 0
                    i++
                }
            }
        }

        @Suppress("NestedBlockDepth")
        private fun calculateGreatestProductOfFourAdjacentNumbers() {
            val js = (3..16).toList()
            val ks = (3..16).toList()

            js.forEach { j ->
                ks.forEach { k ->
                    Orientation.values().forEach { o ->
                        val l = getAdjacentList(o, j, k)
                        if (l.toList().reduce { acc, i -> acc * i } > product) {
                            product = l.toList().reduce { acc, i -> acc * i }
                            sequence = l
                            x = j
                            y = k
                        }
                    }
                }
            }
        }
    }
}
