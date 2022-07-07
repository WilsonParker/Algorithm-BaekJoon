package BaekJoon.A12785

import BaekJoon.Common.printlnArray
import kotlin.test.assertEquals

fun main() {
    assertEquals(test("3 2", "2 2"), 2)
    assertEquals(test("4 4", "2 2"), 10)
}

private fun test(input1: String, input2: String): Int {
    val (w, h) = input1.split(" ").map { it.toInt() - 1 }
    val (x, y) = input2.split(" ").map { it.toInt() - 1 }
    fun find(s: Int, e: Int, t: Int, f: Int): Int {
        val v = Array(f - e + 1) { Array(t - s + 1) { 0 } }
        for (i in s + 1..t)
            v[0][i] = v[0][i - 1] + 1
        for (j in e + 1..f)
            v[j][0] = v[j - 1][0] + 1
        for (i in e..f) {
            for (j in s..t) {
                if (i > 0 && j > 0) {
                    println("$s $e $t $f")
                    v[i][j] = v[i - 1][j] + v[i][j - 1]
                }
            }
        }
        printlnArray(v)
        return v[f][t]
    }

    return find(0, 0, x, y) * find(x, y, h, w) % 1000007
}