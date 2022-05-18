package BaekJoon.A14621

fun main() {
    fun read() = readLine()!!.split(" ")
    val (n, m) = read().map { it.toInt() }
    val l = read()
    val b = Array(n) { Array(n) { 0 } }
    repeat(m) {
        val (u, v, d) = read().map { it.toInt() - 1 }
        b[u][v] = if (b[u][v] == 0 || d + 1 < b[u][v]) d + 1 else b[u][v]
        b[v][u] = if (b[v][u] == 0 || d + 1 < b[v][u]) d + 1 else b[v][u]
    }

    println(b.contentDeepToString())

    var v = Array(n) { -1 }
    fun visit(from: Int, to: Int) {
        if (from != to) {
            v[to] = b[from][to]
        } else {
            v[from] = 0
        }
        for (j in b[to].indices) {
            if (v[j] == -1 && b[to][j] != 0 && l[to] != l[j]) {
                visit(to, j)
            }
        }
    }

    repeat(n) {
        visit(it, it)
        println(v.contentDeepToString())
        println(v.sum())
        v = Array(n) { -1 }
    }
}