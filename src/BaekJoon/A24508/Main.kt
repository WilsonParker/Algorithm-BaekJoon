package BaekJoon.A24508

fun main() {
    val (_, k, t) = readLine()!!.split(" ").map { it.toInt() }
    val v = readLine()!!.split(" ").map { it.toInt() }.sortedByDescending { it }
    print(if (v.sum() % k == 0 && v.slice(0 until v.sum() / k).sumOf { k - it } <= t) "YES" else "NO")
}