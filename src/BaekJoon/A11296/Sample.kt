package BaekJoon.A11296

import kotlin.test.assertEquals

fun main() {
    assertEquals(test("29.99 R X P"), "$16.49")
    assertEquals(test("119.95 W C P"), "$108.25")
    assertEquals(test("68.50 B X P"), "$54.80")
    assertEquals(test("69.90 Y C C"), "$56.40")
}

private fun test(input: String): String {
    val (prc, d, cp, pay) = input.split(" ")
    val dot = mapOf("R" to 0.55, "G" to 0.7, "B" to 0.8, "Y" to 0.85, "O" to 0.9, "W" to 0.95)
    val v = prc.toDouble() * dot[d]!! * if (cp == "C") .95 else 1.0
    val result = if (pay == "P") {
        "$%.2f".format(v)
    } else {
        var t = (v * 100).toInt()
        if (t % 10 < 6)
            t -= t % 10
        "$%.1f0".format(t * .01)
    }
    println(result)
    return result
}