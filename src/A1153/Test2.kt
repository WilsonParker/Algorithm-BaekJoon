package A1153

fun main() {
    val n = readLine()!!.toInt()
    val dr = mutableListOf(2, 3, 5, 7)
    val r = List(n - 2) { it + 2 }
        .filter {
            !dr.any { di -> it % di == 0 } || dr.contains(it)
        }

    if (n < 8)
        print(-1)
    else if (n % 2 == 0) {
        print("2 2")
        goldbach(n - 4, r)
    } else {
        print("2 3")
        goldbach(n - 5, r)
    }
}

private fun goldbach(n: Int, r: List<Int>) {
    for (a in r)
        for (b in r)
            if (n == a + b) {
                print(" $a $b")
                return
            } else if (n < a + b) {
                break
            }
}