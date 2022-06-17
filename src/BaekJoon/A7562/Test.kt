package BaekJoon.A7562

import kotlin.test.assertEquals

fun main() {
    assertEquals(test(8, "0 0", "7 0"), 5)
    assertEquals(test(100, "0 0", "30 50"), 28)
    assertEquals(test(10, "1 1", "1 1"), 0)
}

private fun test(s: Int, input1: String, input2: String): Int {
    val (x, y) = input1.split(" ").map { it.toInt() }
    val (t1, t2) = input2.split(" ").map { it.toInt() }
    val b = Array(s) { Array(s) { 0 } }
    val v = b.copyOf()

    fun move(x: Int, y: Int, d: Int) {
        v[y][x] = 1
        b[y][x] = d
        val m = d + 1
        move(x - 1, y + 1, m)
        move(x + 1, y + 1, m)
    }
    move(x, y, 0)
    return 0
}