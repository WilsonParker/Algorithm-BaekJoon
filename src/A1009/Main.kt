package A1009

fun main() {
    val t = readLine()!!.toInt()
    val toInt = fun(s: Int) = "$s".last().digitToInt()
    val r = ArrayList<Int>()
    for (i in 1..t) {
        var (a, b) = readLine()!!.split(" ").map { it.toInt() }
        a = toInt(a)
        var m = 1
        val l = Array(4) {
            m *= a
            toInt(m)
        }
        val j = b % 4 - 1
        r.add(if (j > 0) l[j] else l[3])
    }
    r.forEach { println(it) }
}