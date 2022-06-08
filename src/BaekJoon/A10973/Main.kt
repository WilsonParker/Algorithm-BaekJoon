package BaekJoon.A10973

import java.util.Collections.swap

fun main() {
    readLine()
    val a = readLine()!!.split(" ").map { it.toInt() }
    val s = a.joinToString(" ")
    fun prev(a: List<Int>): List<Int> {
        var turnIdx = 0
        for (i in a.size - 1 downTo 1) {
            if (a[i] < a[i - 1]) {
                turnIdx = i - 1
                break
            }
        }
        val part = a.slice(0..turnIdx + 1)
        var swapIdx = 0
        for (j in part.size - 1 downTo 0) {
            if (part[j] < a[turnIdx]) {
                swapIdx = j
                break
            }
        }
        swap(a, turnIdx, swapIdx)
        return a
    }

    val r = prev(a).joinToString(" ")
    print(if (s == r) -1 else r)
}