package com.gorauskas.euler.solutions.eleventotwenty

import com.gorauskas.euler.EULER18_TRIANGLE
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer

/**
 * This is a fascinating problem and the solution is really simple and clever.
 * The solution takes from graph theory. See notes below for details. Doing a
 * brute force search on the triangle in this problem works fine but it's
 * not optimal. Problem 67 is basically the same problem as this one, but the
 * input data is too large for brute force. I need a clever algorithm...
 */
@Suppress("CommentOverPrivateFunction")
class Euler18 : EulerSolution {
    /**
     * I want to represent the data as a List of List of Long.
     * So I break the data down by line and then by space and
     * convert it to Long and return the data structure:
     * List<List<Long>>
     */
    val triangle = EULER18_TRIANGLE.trimIndent()
        .split("\n")
        .map { line ->
            line.split(" ").map { it.toLong() }
        }

    override val problem = """
        Project Euler Problem 18:

            By starting at the top of the triangle below and moving to adjacent numbers
            on the row below, the maximum total from top to bottom is 23.

               3
              7 4
             2 4 6
            8 5 9 3

            That is, 3 + 7 + 4 + 9 = 23.

            Find the maximum total from top to bottom of the triangle below:

            $EULER18_TRIANGLE
    """.trimIndent()

    override val answer = """

        The maximum sum travelling from the top of the triangle to
        the base is: ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = findMaxSum(triangle)

    /**
     * We keep accumulating and reducing the triangle until there is only one item left
     * and that's our result.
     * @param tri - the triangle data
     * @return The max sum of the trip from the top
     */
    private fun findMaxSum(tri: List<List<Long>>): Long {
        @Suppress("UNCHECKED_CAST")
        var t = tri as MutableList<MutableList<Long>>

        while (t.size > 1) {
            t = reduceTriangle(t)
        }

        return t[0][0]
    }

    /**
     * The strategy if the algorithm is to treat the data from the bottom up.
     * Here are the steps:
     *
     * 1. Get the last row of the triangle
     * 2. Get the next to the last row of the triangle
     * 3. Loop through the items from step 2 above
     * 4. Find the 2 adjacent items under the item in step 3 above
     * 5. Select the largest of the 2 items in step 4 above
     * 6. Replace the item in step 3 above with the sum of the item in step
     *    5 and its original value
     * 7. remove tha last row from the triangle
     *
     * This is a form of reduction because, when the function returns, the last row
     * contain the accumulation of the values after each iteration of the loop in
     * findMaxSum() above.
     *
     * @param tri - The triangle data to operate on
     * @return a new triangle data structure with one less row.
     */
    private fun reduceTriangle(tri: MutableList<MutableList<Long>>): MutableList<MutableList<Long>> {
        (0 until tri[tri.size - 2].size).forEach { i ->
            tri[tri.size - 2]
                .set(
                    i,
                    tri[tri.size - 2][i] +
                        Math.max(
                            tri[tri.size - 1][i],
                            tri[tri.size - 1][i + 1]
                        )
                )
        }

        tri.removeAt(tri.size - 1)
        return tri
    }
}
