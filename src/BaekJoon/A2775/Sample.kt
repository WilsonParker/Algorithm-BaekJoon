package BaekJoon.A2775

fun main() {
    fun ri() = readLine()!!.toInt()
    val t = ri()
    for (i in 0 until t) {
        val k = ri()
        val n = ri()
        println(num(k, n))
    }
}

fun num(a: Int, b: Int): Int {
    if (b == 1) return 1
    if (a == 0) return b
    return (num(a - 1, b) + num(a, b - 1))
}