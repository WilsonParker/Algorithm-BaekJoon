package BaekJoon.A11296

import java.lang.Math.ceil
import java.lang.Math.floor
import kotlin.test.assertEquals

fun main() {
//    assertEquals(test("29.99 R X P"), "$16.49")
//    assertEquals(test("119.95 W C P"), "$108.25")
//    assertEquals(test("68.50 B X P"), "$54.80")
    assertEquals(test("69.90 Y C C"), "$56.40")
}

private fun test(input: String): String {
    val (prc, d, cp, pay) = input.split(" ")
    val dot = mapOf("R" to 0.55, "G" to 0.7, "B" to 0.8, "Y" to 0.85, "O" to 0.9, "W" to 0.95)
    var res = prc.toDouble() * dot[d]!! * if (cp == "C") 0.95 else 1.0
    val r = if (pay == "C") 100 else 1000
    val c = (res * r % 10).toInt()
    println(res)
    res *= r
    println(res)
    res = if (c > 5) {
        ceil(res)
    } else {
        floor(res)
    }
    println(res)
    return "$%.2f".format(res / r)
}