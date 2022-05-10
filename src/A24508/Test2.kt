package A24508

fun main() {
    println(test("2 2 1", "1 1")) // YES
    println(test("3 5 2", "1 2 2")) // NO
    println(test("3 5 3", "1 2 2")) // YES
    println(test("3 3 100000", "2 1 2")) // NO
}

private fun test(s1: String, s2: String): String {
    val (n, k, t) = s1.split(" ").map { it.toInt() }
    val v = s2.split(" ").map { it.toInt() }.sortedDescending().toMutableList()
    println(v)
    println(v.reduce { acc, i -> acc - k - i })
    return if (v.sum() % k == 0 && v.reduce { acc, i -> acc - k - i } <= t) "YES" else "NO"
}