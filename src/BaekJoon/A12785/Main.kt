package BaekJoon.A12785

fun main() {
    fun rl() = readLine()!!.split(" ").map { it.toInt() - 1 }
    val (w, h) = rl()
    val (x, y) = rl()
    fun find(s: Int, e: Int, t: Int, f: Int): ULong {
        val v = Array(f - e + 1) { Array(t - s + 1) { 0 } }
        for (i in 1..t - s)
            v[0][i] = 1
        for (j in 1..f - e)
            v[j][0] = 1
        for (i in 0..f - e) {
            for (j in 0..t - s) {
                if (i > 0 && j > 0) {
                    v[i][j] = v[i - 1][j] + v[i][j - 1]
                }
            }
        }
        val r = v[f - e][t - s]
        return if (r == 0) 1u else r.toULong()
    }

    print("${find(0, 0, x, y) * find(x, y, h, w) % 1000007u}")
}