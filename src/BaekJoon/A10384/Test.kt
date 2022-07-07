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
    val l = ('a'..'z').toList()
    val c = input.toCharArray().map { it.lowercaseChar() }.filter { l.contains(it) }.groupBy { it }.map { it to it.value.count() }.toMap()
    val r = if (c.keys.count() == 26) c.values.minOf { it } else 0
    return "Case $case: " +
            when (r) {
                3 -> "Triple pangram!!!"
                2 -> "Double pangram!!"
                1 -> "Pangram!"
                else -> "Not a pangram"
            }
}