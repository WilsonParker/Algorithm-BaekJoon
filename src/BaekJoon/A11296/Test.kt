package BaekJoon.A11296

import kotlin.test.assertEquals

fun main() {
//    assertEquals(test("29.99 R X P"), "$16.49")
//    assertEquals(test("119.95 W C P"), "$108.25")
//    assertEquals(test("68.50 B X P"), "$54.80")
//    assertEquals(test("69.90 Y C C"), "$56.40")

//    assertEquals(test("25.96 Y C C"), "$21.00")
//    assertEquals(test("18.14 Y C C"), "$14.60")
//    assertEquals(test("18.29 Y C C"), "$14.80")

    assertEquals(test("18.29 Y C C"), "$14.80")
}

private fun test(input: String): String {
    val (prc, d, cp, pay) = input.split(" ")
    val dot = mapOf("R" to 0.55, "G" to 0.7, "B" to 0.8, "Y" to 0.85, "O" to 0.9, "W" to 0.95)
    val r = if (pay == "C") 100 else 1000
    var res = (prc.toDouble() * dot[d]!! * if (cp == "C") 0.95 else 1.0) * r
    println(res)

    val c = (res % 10).toInt()
    res *= 0.1
    res = if (c > 5) Math.ceil(res) else Math.floor(res)
    println("$%.2f".format(res * 10 / r))
    return "$%.2f".format(res * 10 / r)
}