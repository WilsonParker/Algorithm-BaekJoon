package BaekJoon.A11296

fun main() {
    repeat(readLine()!!.toInt()) {
        val (prc, d, cp, pay) = readLine()!!.split(" ")
        val dot = mapOf("R" to 0.55, "G" to 0.7, "B" to 0.8, "Y" to 0.85, "O" to 0.9, "W" to 0.95)
        val r = if (pay == "C") 100 else 1000
        var res = (prc.toDouble() * dot[d]!! * if (cp == "C") 0.95 else 1.0) * r
        val c = (res % 10).toInt()
        res *= 0.1
        res = if (c > 5) Math.ceil(res) else Math.floor(res)
        res = res * 10 / r
        println("$%.${if (res % 1 == 0.0) 1 else 2}f".format(res))
    }
}