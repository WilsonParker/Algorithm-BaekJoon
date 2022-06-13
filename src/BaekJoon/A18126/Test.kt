package BaekJoon.A18126

import kotlin.math.max
import kotlin.test.assertEquals

fun main() {
    assertEquals(
        test(
            4,
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(2, 3, 2),
                arrayOf(2, 4, 4)
            )
        ),
        7
    )

    assertEquals(
        test(
            4,
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(1, 3, 3),
                arrayOf(2, 4, 4)
            )
        ),
        7
    )

    assertEquals(
        test(
            5,
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(1, 3, 3),
                arrayOf(3, 4, 5),
                arrayOf(2, 4, 4)
            )
        ),
        8
    )
}

private fun test(n: Int, b: Array<Array<Int>>): Int {
    val r = Array(n) { Array(n) { 0 } }
    for (i in b) r[i[0] - 1][i[1] - 1] = i[2]
    println(r.contentDeepToString())
    return 1
}