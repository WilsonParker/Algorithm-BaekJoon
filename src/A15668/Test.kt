package A15668

fun main() {
    // val n = readLine()!!.toInt()
    val n = "555"
    val al = ArrayList<Int>()
    val bl = ArrayList<Int>()
    var a = 0
    var b = 0

    var loop = true
    val m = n.length
    var f = n.first().digitToInt()
    do {
        al.add(f)
        for (i in f downTo 1) {
            for (j in 1..9) {
                if (!al.contains(j)) {
                    al.add(j)
                    if (al.size == m) {
                        println(al.joinToString("").toInt())
                        for (k in 1..9) {
                            if (!al.contains(k) && !bl.contains(k)) {
                                bl.add(k)
                                if (al.joinToString("").toInt() + bl.joinToString("").toInt() > n.toInt()) {

                                }
                            }
                        }
                    }
                }
            }
        }
        println(al.joinToString("").toInt())
        f--
        loop = false
    } while (loop)

    println(al)
    println(bl)
}

private fun getInt(l: Int) {
}

private fun toInt(l: List<Int>): Int {
    return l.joinToString("").toInt()
}