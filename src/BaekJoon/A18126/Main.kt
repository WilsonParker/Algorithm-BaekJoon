package BaekJoon.A18126

fun main() {
    val n = readLine()!!.toInt()
    val b = (1 until n).map { readLine()!!.split(" ").map { it.toInt() } }
    fun move(i: Int, j: Int, d: Int, v: Array<Int>): Int {
        v[i] = 1
        var m = d
        for (k in b.filter { it[0] == j }) {
            if (v[k[0]] == 0) {
                val r = move(j, k[1], d + k[2], v.clone())
                if (r > m) m = r
            }
        }
        return m
    }

    var m = 0
    for (i in b.filter { it[0] == 1 }) {
        val r = move(i[0], i[1], i[2], Array(n) { 0 })
        if (r > m) m = r
    }
    print(m)
}