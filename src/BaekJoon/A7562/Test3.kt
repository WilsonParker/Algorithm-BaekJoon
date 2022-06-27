package BaekJoon.A7562

import BaekJoon.Common.printlnArray
import java.util.*
import kotlin.test.assertEquals

fun main() {
    assertEquals(test(8, "0 0", "7 0"), 5)
    assertEquals(test(100, "0 0", "30 50"), 28)
    assertEquals(test(10, "1 1", "1 1"), 0)
}

private fun test(size: Int, input1: String, input2: String): Int {
    val (s, e) = input1.split(" ").map { it.toInt() }
    val (tX, tY) = input2.split(" ").map { it.toInt() }
    val dX = arrayOf(1, 1, 2, 2, -1, -1, -2, -2)
    val dY = arrayOf(-2, 2, -1, 1, -2, 2, -1, 1)
    val v = Array(size) { Array(size) { false } }
    val d = Array(size) { Array(size) { 0 } }
    val b = LinkedList<Pair<Int, Int>>()

    fun bfs(i: Int, j: Int) {
        b.add(Pair(i, j))
        v[j][i] = true
        while (b.isNotEmpty()) {
            val p = b.pop()
            val x = p.first
            val y = p.second

            if (x == tX && y == tY) {
                println(d[y][x])
                break
            }

            for (k in 0..7) {
                val nX = x + dX[k]
                val nY = y + dY[k]
                if (nX in 0 until size && nY in 0 until size && !v[nY][nX]) {
                    v[nY][nX] = true
                    d[nY][nX] = d[y][x] + 1
                    b.add(Pair(nX, nY))
                }
            }
        }
    }

    bfs(s, e)
    printlnArray(d)
    return d[tX][tY]
}