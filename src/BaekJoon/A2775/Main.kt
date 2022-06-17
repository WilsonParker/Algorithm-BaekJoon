package BaekJoon.A2775

fun main() {
    fun ri() = readLine()!!.toInt()
    val t = ri()
    repeat(t) {
        val k = ri()
        val n = ri()
        val b = Array(k + 1) { Array(n) { it + 1 } }
        b.forEachIndexed { idx, _ ->
            if (idx > 0)
                for (i in 1 until n)
                    b[idx][i] = b[idx][i - 1] + b[idx - 1][i]
        }
        println(b[k][n - 1])
    }
}