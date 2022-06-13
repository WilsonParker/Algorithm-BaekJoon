package BaekJoon.A18126

import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val b = (1 until n).map { readLine()!!.split(" ").map { it.toInt() } }
    fun move(i: Int, d: Int = 0): Int {
        var m = d
        for (j in b)
            if (j[0] == i)
                m = max(m, move(j[1], d + j[2]))
        return m
    }
    print(move(1))
}
