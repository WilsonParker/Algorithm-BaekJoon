package A11562

import java.lang.Integer.min

var arr: Array<Int> = emptyArray()
var n: Int = 0
var m: Int = 0

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    arr = Array(n + 1) { 0 }

    for (i in 1..n)
        arr[i] = 1 shl (i - 1)
    for (i in 1..m) {
        val l = readLine()!!.split(" ").map { it.toInt() }
        arr[l[0]] += 1 shl l[1] - 1
        if (l[2] == 1)
            arr[l[1]] += 1 shl l[0] - 1
    }

    val k = readLine()!!.toInt()
    val arr2 = Array(k) { 0 }
    for (i in 0 until k) {
        val (f, b) = readLine()!!.split(" ").map { it.toInt() }
        arr2[i] = move(f, b)
    }

    arr.forEach { println(Integer.toBinaryString(it).padStart(4, '0')) }
    arr2.forEach { println(it) }
}

private fun move(a: Int, b: Int, c: Int = 0): Int {
    // println("n : m = $n $m")
    var d = if (a < b) 1 else -1
    return if (arr[a] == 1 shl a) {
        move(a + d, b, c + if (arr[a].and(1 shl a - 1) > 0) 0 else 1)
    } else {
        var min = b
        Integer.toBinaryString(arr[a]).toCharArray().forEachIndexed { idx, ch ->
            if (ch == '1') {
                min = min(
                    min,
                    move(a + 1, b, c + if (arr[a].and(1 shl idx) > 0) 0 else 1)
                )
            }
        }
        min
    }


    return if (a < b) {
        if (arr[a] == 1 shl a) {
            move(a + 1, b, c + if (arr[a].and(1 shl a - 1) > 0) 0 else 1)
        } else {
            var min = b
            Integer.toBinaryString(arr[a]).toCharArray().forEachIndexed { idx, ch ->
                if (ch == '1') {
                    min = min(
                        min,
                        move(a + 1, b, c + if (arr[a].and(1 shl idx) > 0) 0 else 1)
                    )
                }
            }
            min
        }
    } else if (a > b) {
        if (arr[a] == 1 shl a) {
            move(a - 1, b, c + if (arr[a].and(1 shl a - 2) > 0) 0 else 1)
        } else {
            var min = b
            Integer.toBinaryString(arr[a]).toCharArray().forEachIndexed { idx, ch ->
                if (ch == '1') {
                    min = min(
                        min,
                        move(a - 1, b, c + if (arr[a].and(1 shl idx) > 0) 0 else 1)
                    )
                }
            }
            min
        }
    } else {
        c
    }
}

// 0011
// 0110
// 1110
// 1000