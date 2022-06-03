package BaekJoon.A10973

fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!.split(" ").map { it.toInt() }
    val l = Array(n) { it + 1 }.partition { it != s[0] }
    val r = p(l.first, l.second)
    val i = r.indexOf(s.joinToString(" ")) - 1
    print(if (i > 0) r[i] else -1)
}

private fun p(l: List<Int>, s: List<Int>, e: List<Int> = l.toList()): List<String> = when (e.size) {
    0 -> listOf(s.joinToString(" "))
    else -> e.flatMap { p(l, s + it, e - it) }
}