package BaekJoon.A7562

import java.util.*

fun main() {
    fun ri() = readLine()!!.toInt()
    fun rl() = readLine()!!.split(" ").map { it.toInt() }
    val dX = arrayOf(1, 1, 2, 2, -1, -1, -2, -2)
    val dY = arrayOf(-2, 2, -1, 1, -2, 2, -1, 1)
    repeat(ri()) {
        val n = ri()
        val (sX, sY) = rl()
        val (eX, eY) = rl()
        val q = LinkedList<Pair<Int, Int>>()
        q.add(Pair(sX, sY))
        val v = Array(n) { Array(n) { 0 } }
        val d = Array(n) { Array(n) { 0 } }
        v[sY][sX] = 1
        while (q.isNotEmpty()) {
            val p = q.remove()
            val x = p.first
            val y = p.second
            for (i in 0..7) {
                val nX = x + dX[i]
                val nY = y + dY[i]
                if (nX in 0 until n && nY in 0 until n && v[nY][nX] == 0) {
                    v[nY][nX] = 1
                    d[nY][nX] = d[y][x] + 1
                    q.add(Pair(nX, nY))
                }
            }
        }
        println(d[eY][eX])
    }
}