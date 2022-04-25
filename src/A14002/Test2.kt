package A14002

fun main() {
    val n = readLine()!!.toInt()
    val v = readLine()!!.split(" ").map { it.toInt() }
    val d = ArrayList<Int>()

    d.add(0)
    for (i in v.indices) {
        for (j in d.size - 1 downTo 0) {
            if (v[i] > v[d[j]]) {
                println("${v[i]} ${d[j]} $i $j")
                d.add(d[j] + 1)
                break
            }
        }
    }

    // println(d.contentDeepToString())
    println(d.joinToString(","))
}