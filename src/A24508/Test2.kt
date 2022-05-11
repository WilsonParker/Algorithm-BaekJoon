package A24508

fun main() {
//    println(test("2 2 1", "1 1")) // YES
//    println(test("3 5 2", "1 2 2")) // NO
//    println(test("3 5 3", "1 2 2")) // YES
//    println(test("3 3 100000", "2 1 2")) // NO
//    println(test("4 3 2", "2 1 2 1")) // YES
//    println(test("4 4 2", "2 2 2 2")) // NO
//    println(test("4 4 3", "3 2 1 2")) // YES
//    println(test("2 100000 1000000000", "99999 1")) // YES
//    println(test("6 6 2", "5 3 3 3 2 2")) // NO
    println(test("6 1 0", "0 0 0 0 0 0")) //
}

private fun test(s1: String, s2: String): String {
    val (_, k, t) = s1.split(" ").map { it.toInt() }
    val v = s2.split(" ").map { it.toInt() }.sortedDescending()
    println(v)
    println(v.slice(0 until v.sum() / k))
    println(v.slice(0 until v.sum() / k).sumOf { k - it })
    return if (v.sum() % k == 0 && v.slice(0 until v.sum() / k).sumOf { k - it } <= t) "YES" else "NO"
}