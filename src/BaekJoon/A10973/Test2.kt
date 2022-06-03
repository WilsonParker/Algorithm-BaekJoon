package BaekJoon.A10973

fun main() {
    println(1)
    test(5)
}

private fun test(n: Int) {
    val s = Array(n) { it + 1 }
    val l = Array(n) { it + 1 }.partition { it != s[0] }
    println(s)
    val r = p(l.first, l.second)
    val i = r.indexOf(s.joinToString(" ")) - 1
    println(r)
    print(if (i > 0) r[i] else -1)
}

private fun p(l: List<Int>, s: List<Int>, e: List<Int> = l.toList()): List<String> = when (e.size) {
    0 -> listOf(s.joinToString(" "))
    else -> e.flatMap { p(l, s + it, e - it) }
}