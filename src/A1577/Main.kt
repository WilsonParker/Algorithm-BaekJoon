package A1577

fun main() {
    val (n, m) = readln()!!.split(" ").map { it.toInt() + 1 }
    val k = readln()!!.toInt()
    var r = 0
    val l = Array(m) {
        Array(n) {
            0
        }
    }
    for (i in 0 until k) {
        val (a, b, c, d) = readln()!!.split(" ").map { it.toInt() }
        l[a][b] = -1
        l[c][d] = -1
    }

    l.forEach { println(it.contentDeepToString()) }
    println(move(0, 0, n, m, l, 0))
    l.forEach { println(it.contentDeepToString()) }
}

private fun move(x: Int, y: Int, n: Int, m: Int, l: Array<Array<Int>>, c: Int): Int {
    l[y][x] += 1
    return if (x == n - 1 && y == m - 1) c
    else {
        if (x + 1 < n && l[y][x + 1] != -1)
            move(x + 1, y, n, m, l, c + 1)
        else 0
        +
        if (y + 1 < m && l[y + 1][x] != -1)
            move(x, y + 1, n, m, l, c + 1)
        else 0
    }
}