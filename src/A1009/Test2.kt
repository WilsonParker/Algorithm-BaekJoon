package A1009

fun main() {
    val t = readLine()!!.toInt()
    val toInt = fun(s: Int) = "$s".last().digitToInt()
    for (i in 1..t) {
        var (a, b) = readLine()!!.split(" ").map { it.toInt() }
        a = toInt(a)
        var m = 1
        val l = Array(4) {
            m *= a
            toInt(m)
        }
        val j = b % 10 % 4 -1
        println(if (j > 0) l[j] else l[3])
    }
}