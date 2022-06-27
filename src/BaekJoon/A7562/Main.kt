package BaekJoon.A7562

fun main() {
    repeat(readLine()!!.toInt()) {
        val size = readLine()!!.toInt()
        val (s, e) = readLine()!!.split(" ").map { it.toInt() }
        val (t1, t2) = readLine()!!.split(" ").map { it.toInt() }
        val v = Array(size) { Array(size) { -1 } }
        v[s][e] = 0

        fun move(x: Int, y: Int, d: Int) {
            if (x in 0 until size && y in 0 until size && v[y][x] < 1)
                v[y][x] = d + 1
        }

        fun start(x: Int, y: Int, d: Int) {
            move(x - 2, y - 1, d)
            move(x - 2, y + 1, d)
            move(x + 2, y - 1, d)
            move(x + 2, y + 1, d)
            move(x - 1, y + 2, d)
            move(x + 1, y + 2, d)
            move(x - 1, y - 2, d)
            move(x + 1, y - 2, d)
        }

        while (v[t1][t2] < 0) {
            for (i in 0 until size)
                for (j in 0 until size)
                    if (v[i][j] > -1)
                        start(j, i, v[i][j])
        }

        println(v[t1][t2])
    }
}