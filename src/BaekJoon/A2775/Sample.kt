package BaekJoon.A2775

fun main() = repeat(readLine()!!.toInt()) {
    List(2) { readLine()!!.toInt() }.let { i ->
        println(count(i[0], i[1]))
    }
}

fun count(k: Int, n: Int): Int = if (k == 0) n else (1..n).sumOf { count(k - 1, it) }
