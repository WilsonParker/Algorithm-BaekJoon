package BaekJoon.A25175

import kotlin.math.abs

fun main() {
    val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    val r = if (k > 2) (m + k - 3) % n else (abs(n - (3 - k)) + m) % n
    print(if (r == 0) n else r)
}