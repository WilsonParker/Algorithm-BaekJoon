package BaekJoon.A2775

import kotlin.test.assertEquals

fun main() {
    assertEquals(test(1, 3), 6)
    assertEquals(test(2, 3), 10)
}

private fun test(k: Int, n: Int): Int {
    val b = Array(k + 1) { Array(n) { it + 1 } }
    b.forEachIndexed { idx, _ ->
        if (idx > 0)
            for (i in 1 until n)
                b[idx][i] = b[idx][i - 1] + b[idx - 1][i]
    }
    return b[k][n - 1]
}

/*
* 5 / 1 7 28 84 200
* 4 / 1 6 21 56 116
* 3 / 1 5 15 35 60
* 2 / 1 4 10 20 35
* 1 / 1 3 6 10 15
* 0 / 1 2 3 4 5
* */