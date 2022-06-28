package BaekJoon.A1244

import BaekJoon.Common.printArray
import BaekJoon.Common.printlnArray
import kotlin.test.assertEquals

fun main() {
    assertEquals(test(8, "0 1 0 1 0 0 0 1", 2, arrayOf("1 3", "2 3")), "1 0 0 0 1 1 0 1")
}

private fun test(n: Int, s: String, c: Int, l: Array<String>): String {
    val brd = s.split(" ").toMutableList()
    val m = l.map { it.split(" ").map { i -> i.toInt() } }
    fun change(idx: Int) {
        brd[idx] = if (brd[idx] == "1") "0" else "1"
    }
    for (i in 0 until c) {
        val t = m[i][1]
        if (m[i][0] == 1) {
            brd.forEachIndexed { idx, b ->
                if ((idx + 1) % t == 0) {
                    change(idx)
                }
            }
        } else {
            for (j in 1 until n - t) {
                if (t - j in 0 until n && t + j in 0 until n && brd[t - j] == brd[t + j]) {
                    change(t - j)
                    change(t + j)
                }
            }
        }
        println(brd)
    }
    printlnArray(m)
    return brd.joinToString(" ")
}

