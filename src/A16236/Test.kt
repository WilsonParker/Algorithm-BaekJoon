package A16236

fun main() {
    val n = readLine()!!.toInt()
    val l = Array(n) { readLine()!!.split(" ").map { it.toInt() } }
    println(l.contentDeepToString())

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (l[i][j] == 9)
                arrayOf(i, j)
        }
    }
}