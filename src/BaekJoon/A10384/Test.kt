package BaekJoon.A10384

import kotlin.test.assertEquals

fun main() {
    assertEquals(test(1, "The quick brown fox jumps over a lazy dog."), "Case 1: Pangram!")
    assertEquals(test(2, "The quick brown fox jumps over a laconic dog."), "Case 2: Not a pangram")
    assertEquals(
        test(3, "abcdefghijklmNOPQRSTUVWXYZ-zyxwvutsrqpon   2013/2014      MLKJIHGFEDCBA"),
        "Case 3: Double pangram!!"
    )
}

private fun test(case: Int, input: String): String {
    val c = ('a'..'z').map { it to 0 }
    input.toCharArray().filter { it != ' ' }.groupBy { it }.map { it.value.count() }
    for (a in 'a'..'z') {
        println(a)
    }
    println(c)
    return "Case $case: " + if (c[0] != c[c.size - 1])
        "Not a pangram"
    else {
        when (c[0]) {
            1 -> "Pangram!"
            2 -> "Double pangram!!"
            2 -> "Triple pangram!!!"
            else -> ""
        }
    }
}