package BaekJoon.A2343

import BaekJoon.Common.printlnArray

fun main() {
    // 9 개 를 3 묶음
    test(9, 3)
}

private fun test(n: Int, m: Int) {
    val d = Array(m) { 1 }
    d[0] += n - m
    val r = ArrayList<Array<Int>>()
    r.add(d)
    execute(0, m, d, r)
    printlnArray(r)
}

private fun execute(s: Int, m: Int, d: Array<Int>, r: ArrayList<Array<Int>>) {
    if (s < m - 1) {
        while (d[s] > 1) {
            d[s]--
            d[s + 1]++
            r.add(d.copyOf())
        }
        execute(s + 1, m, d, r)
    } else {

    }
}