package A1009

fun main() {
    val t = readLine()!!.toInt()
    for (i in 1..t) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        var m = 1
        val l = Array(4) {
            m *= a
            "$m".last().digitToInt()
        }
        val j = b % 4 - 1
        println(if(j>0) l[j] else l[3])
    }
}