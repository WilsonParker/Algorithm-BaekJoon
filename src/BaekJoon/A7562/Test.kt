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
    val b = Array(size) { Array(size) { 0 } }
    val v = Array(size) { Array(size) { 0 } }

    fun move(x: Int, y: Int, d: Int) {
        if (x in 0 until size && y in 0 until size && v[y][x] == 0 && b[y][x] == 0) {
            v[y][x] = 1
            b[y][x] = d
            if (d == 10) {
                return
            }
            val m = d + 1
            move(x - 2, y - 1, m)
            move(x - 2, y + 1, m)
            move(x + 2, y - 1, m)
            move(x + 2, y + 1, m)
            move(x - 1, y + 2, m)
            move(x + 1, y + 2, m)
            move(x - 1, y - 2, m)
            move(x + 1, y - 2, m)
        }
    }
    move(s, e, 0)
    printlnArray(b)
    println()
    printlnArray(v)
    return 0
}

/*
    * 2,2
    *
    * 0,1
    * 0,3
    * 1,0
    * 1,3
    * 1,4
    * 3,4
    * 4,1
    * 4,3
    *
    * ㅁㅇㅁㅇㅁ
    * ㅇㅁㅁㅁㅇ
    * ㅁㅁXㅁㅁ
    * ㅇㅁㅁㅁㅇ
    * ㅁㅇㅁㅇㅁ
    *
    * */