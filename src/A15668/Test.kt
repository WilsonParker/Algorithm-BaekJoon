package A15668

fun main() {
    // val n = readLine()!!.toInt()
    val n = "555"
    val al = ArrayList<Int>()
    val bl = ArrayList<Int>()
    var a = 0
    var b = 0

    do {
        var m = n.length
        for (i in 1..m) {
            for (j in 1..9) {
                if (!al.contains(j)) {
                    al.add(j)
                    break;
                }
            }
        }
        a = al.joinToString("").toInt()
    } while (a )

    println(al)
}

private fun getInt(l: Int) {
}

private fun toInt(l: List<Int>): Int {
    return l.joinToString("").toInt()
}