package BaekJoon.A2775

import kotlin.test.assertEquals

fun main() {
    assertEquals(test(1, 3), 6)
    assertEquals(test(2, 3), 10)
}

private fun test(k: Int, n: Int): Int {
    val b = (0..k).map {
        if (it > 0) {
            Array(n) { b[1] }
        } else {
            Array(n) { it }
        }
    }
    return 0
}

/*
* 4 / 1 6 21
* 3 / 1 5 15
* 2 / 1 4 10
* 1 / 1 3 6
* 0 / 1 2 3
* */