package BaekJoon.A10973

import java.util.Collections.swap

fun main() {
    test(arrayOf(1, 9, 4, 6, 7)) // 1 7 4 6 9
    test(arrayOf(3, 2, 1)) // 3 1 2
}

private fun test(r: Array<Int>) {
    fun prev(a: Array<Int>): Array<Int> {
        var turnIdx = 0
        for (i in a.size - 1 downTo 0) {
            if (a[i] < a[i - 1]) {
                turnIdx = i - 1
                break
            }
        }

        val lastPart = a.slice(0..turnIdx + 1)
        var swapIdx = 0
        for (j in lastPart.size - 1 downTo -1) {
            if (lastPart[j] < a[turnIdx]) {
                swapIdx = j + 1
                break
            }
        }

        println(lastPart)
        println("$turnIdx $swapIdx")
        swap(a.asList(), turnIdx, swapIdx)
        return a
    }

    println(r.contentDeepToString())
    println(prev(r).contentDeepToString())
}
