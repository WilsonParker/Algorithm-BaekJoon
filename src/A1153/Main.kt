package A1153

fun main() {
    val n = readLine()!!.toInt()
    val dr = mutableListOf(2, 3, 5, 7)
    val r = List(n - 2) { it + 2 }
        .filter {
            !dr.any { di -> it % di == 0 } || dr.contains(it)
        }
    for (a in r)
        for (b in r)
            if (n - 4 == a + b) {
                print("2 2 $a $b")
                return
            } else if (n - 5 == a + b) {
                print("2 3 $a $b")
                return
            }
    print(-1)
}