package BaekJoon.A1244

fun main() {
    val n = readLine()!!.toInt()
    val brd = readLine()!!.split(" ").toMutableList()
    val m = Array(readLine()!!.toInt()) { readLine()!!.split(" ").map { it.toInt() } }
    fun change(idx: Int) {
        brd[idx] = if (brd[idx] == "1") "0" else "1"
    }
    for (i in m.indices) {
        var t = m[i][1]
        if (m[i][0] == 1) {
            brd.forEachIndexed { idx, b ->
                if ((idx + 1) % t == 0) {
                    change(idx)
                }
            }
        } else {
            t--
            change(t)
            for (j in 1 until n - t) {
                if (t - j in 0 until n && t + j in 0 until n && brd[t - j] == brd[t + j]) {
                    change(t - j)
                    change(t + j)
                } else break
            }
        }
    }

    brd.chunked(20).forEach { println(it.joinToString(" ")) }
}