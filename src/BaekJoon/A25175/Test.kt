package BaekJoon.A25175

fun main() {
    // val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    val (n, m, k) = arrayOf(7, 2, 4)
//    val (n, m, k) = arrayOf(6, 1, -1)
    val l = Array(n) { it + 1 }
    fun idx(i: Int) = if (i < 0) m - i *-1 else m - i
    l[idx(m - 1)] = 3
    l[idx(m - 2)] -= 1
    l[m] += 1
    print(l.find { it == k })
    // 1 2 3 4 5 6
    // 2 1 1
    // 1 0 6
    // 6 0 1
}