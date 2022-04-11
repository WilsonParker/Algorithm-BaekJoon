package A2435

fun main() {
    val (c, d) = readLine()!!.split(" ").map { it.toInt() }
    var l = arrayOf(0)
    for (i in 0..c) {
    }
    var max = 0
    for (i in 0..c - d) {
        var sum = 0
        for (j in i until i + d)
            sum += l[j]
        max = if (max < sum) sum else max
    }
    print(max)
}