package A1009

fun main() {
    val t = readLine()!!.toInt()
    val r = ArrayList<Int>()
    for (i in 1..t) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        var m = 1
        val l = Array(4) {
            m *= a
            "$m".last().digitToInt()
        }
        val j = b % 4 - 3 * -1
        r.add(l[j])
    }
    r.forEach { println(it) }
}