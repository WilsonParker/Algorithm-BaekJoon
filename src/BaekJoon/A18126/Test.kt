package BaekJoon.A18126

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
                arrayOf(2, 4, 4),
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
                arrayOf(2, 4, 4),
            )
        ),
        8
    )

    assertEquals(
        test(
            7,
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(2, 3, 2),
                arrayOf(2, 4, 4),
                arrayOf(4, 5, 6),
                arrayOf(4, 6, 5),
                arrayOf(5, 3, 2),
            )
        ),
        15
    )

    assertEquals(
        test(
            2,
            arrayOf(
                arrayOf(1, 2, 3),
            )
        ),
        3
    )

    assertEquals(
        test(
            2,
            arrayOf(
                arrayOf(2, 2, 3),
            )
        ),
        0
    )
}

private fun test(n: Int, b: Array<Array<Int>>): Int {
    fun move(i: Int, j: Int, d: Int, v: Array<Int>): Int {
        v[i] = 1
        var m = d
        for (k in b.filter { it[0] == j }) {
            if (v[j] == 0) {
                val r = move(j, k[1], d + k[2], v.copyOf())
                if (r > m) m = r
            }
        }
        return m
    }

    var m = 0
    for (i in b.filter { it[0] == 1 }) {
        val r = move(i[0], i[1], i[2], Array(n) { 0 })
        if (r > m) m = r
    }
    return m
}