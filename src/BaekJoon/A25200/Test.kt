package BaekJoon.A25200

fun main() {
    val (n, m) = arrayOf(5, 4)
    val r = arrayOf(
        arrayOf(1, 3),
        arrayOf(3, 2),
        arrayOf(4, 3),
        arrayOf(2, 4),
    )

    fun move(d: Int, i: Int = 0): Int {
        val idx = r.indexOf(r.find { it[0] == d })
        return if (idx == m - 1 && idx > i)
            r[idx][1]
        else if (idx in 0 until m - 1)
            move(r[idx][1], idx)
        else d
    }

    print((1..n).map { move(it) }.joinToString(" "))
}