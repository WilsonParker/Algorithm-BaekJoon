package BaekJoon.A12785

fun main() {
    fun rl() = readLine()!!.split(" ").map { it.toInt() - 1 }
    val (w, h) = rl()
    val (x, y) = rl()
    fun find(s: Int, e: Int, t: Int, f: Int): Int {
        val v = Array(w + 1) { Array(h + 1) { 0 } }
        for (i in s + 1..t)
            v[0][i] = v[0][i - 1] + 1
        for (j in e + 1..f)
            v[j][0] = v[j - 1][0] + 1
        for (i in e..f)
            for (j in s..t)
                if (i > 0 && j > 0)
                    v[i][j] = v[i - 1][j] + v[i][j - 1]
        return v[f][t]
    }

    print(find(0, 0, x, y) * find(x, y, h, w) % 1000007)
}