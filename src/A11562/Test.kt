package A11562

import kotlin.math.pow

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(n) { 0 }

    for (i in 0 until n)
        arr[i] = 2.0.pow(i).toInt()
    for (i in 0 until m) {
        val l = readLine()!!.split(" ").map { it.toInt() }
        if (l[2] == 1) {
            // arr[l[1] - 1] += 2.0.pow(l[0]).toInt()
        }
    }
    printArr(arr)

//    0001
//    0010
//    0110
//    1000
//
//    1 1 0
//    1 2 0
//    2 1 1
//    1 4 0
//    4 1 2
//    2 3 0
//    4 3 1
}

private fun printArr(arr: Array<Int>) {
    arr.forEach { println(Integer.toBinaryString(it)) }
    println()
}