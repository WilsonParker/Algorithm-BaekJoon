package BaekJoon.A7562

import java.util.*
import kotlin.test.assertEquals

fun main() {
    assertEquals(test(8, "0 0", "7 0"), 5)
    assertEquals(test(100, "0 0", "30 50"), 28)
    assertEquals(test(10, "1 1", "1 1"), 0)
}

private fun test(size: Int, input1: String, input2: String): Int {
    val (s, e) = input1.split(" ").map { it.toInt() }
    val (t1, t2) = input2.split(" ").map { it.toInt() }
    val v = Array(size) { Array(size) { -1 } }
    val b = Array(size) { Array(size) { LinkedList<Pair<Int, Int>>() } }
    v[s][e] = 0

    fun add(s: Int, e: Int, x: Int, y: Int, d: Int) {
        if (x in 0 until size && y in 0 until size && v[y][x] < 1) {
            v[y][x] = d + 1
            b[s][e].add(Pair(y - 1, x - 2))
        }
    }

    fun start(x: Int, y: Int, d: Int) {
        add(x, y, x - 2, y - 1, d)
        add(x, y, x - 2, y + 1, d)
        add(x, y, x + 2, y - 1, d)
        add(x, y, x + 2, y + 1, d)
        add(x, y, x - 1, y + 2, d)
        add(x, y, x + 1, y + 2, d)
        add(x, y, x - 1, y - 2, d)
        add(x, y, x + 1, y - 2, d)
    }

    while (v[t1][t2] < 0) {
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (v[i][j] > -1) {
                    start(j, i, v[i][j])
                }
            }
        }
    }

    return v[t1][t2]
}