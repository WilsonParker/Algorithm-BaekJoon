package BaekJoon.A11296

fun main() {
    repeat(readLine()!!.toInt()) {
        val (prc, d, cp, pay) = readLine()!!.split(" ")
        val dot = mapOf("R" to 0.55, "G" to 0.7, "B" to 0.8, "Y" to 0.85, "O" to 0.9, "W" to 0.95)
        val res = prc.toDouble() * dot[d]!! * if (cp == "C") 0.95 else 1.0
        val r = if (pay == "C") 100 else 1000
        val c = (res * r % 10).toInt()
        println(res)
        println(c)
        println((res * r))
        println((res * r + if (c > 5) 1 else c * -1))
        println((res * r + if (c > 5) 1 else c * -1) / r)
        println("\$%.2f".format((res * r + if (c > 5) 1 else c * -1) / r))
    }
}