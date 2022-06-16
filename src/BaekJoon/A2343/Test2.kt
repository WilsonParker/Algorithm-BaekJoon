package BaekJoon.A2343

import kotlin.test.assertEquals

fun main() {
    assertEquals(test(9, 3, "1 2 3 4 5 6 7 8 9".split(" ").map { it.toInt() }), "17")
}

private fun test(n: Int, m: Int, d: List<Int>): String {
    for (i in 1 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {

            }
        }
    }

    return "17"
}

private fun permutation(a: Array<Int>, s: List<Int> = a.asList(), e: Array<Int>) {

}