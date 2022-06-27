package BaekJoon.A7562

import BaekJoon.Common.printlnArray
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
    val b = ArrayList<Array<Int>>()
    b.add(arrayOf(s, e, 0))
    v[s][e] = 0

    fun move(x: Int, y: Int, d: Int) {
        if (x in 0 until size && y in 0 until size && v[y][x] < 1) {
            v[y][x] = d + 1
            b.add(arrayOf(y, x, d + 1))
        }
    }

    fun start(x: Int, y: Int, d: Int) {
        move(x - 2, y - 1, d)
        move(x - 2, y + 1, d)
        move(x + 2, y - 1, d)
        move(x + 2, y + 1, d)
        move(x - 1, y + 2, d)
        move(x + 1, y + 2, d)
        move(x - 1, y - 2, d)
        move(x + 1, y - 2, d)
    }

    while (v[t1][t2] < 0)
        for (i in b.indices) {
            val it = b[i]
            start(it[0], it[1], it[2])
        }

    printlnArray(b)
    println()
    printlnArray(v)

    return v[t1][t2]
}