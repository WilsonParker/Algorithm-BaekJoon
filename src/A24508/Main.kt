package A24508

fun main() {
    var (n, k, t) = readLine()!!.split(" ").map { it.toInt() }
    val v = readLine()!!.split(" ").map { it.toInt() }.sortedDescending().toMutableList()
    var m = v.size - 1
    for (i in v.indices) {
        while (v[i] < k && m > i) {
            if (v[m] > 0) {
                if (t > 0) {
                    v[m] -= 1
                    v[i] += 1
                    t -= 1
                } else {
                    print("NO")
                    return
                }
            } else {
                m -= 1
            }
        }
    }
    print(if (v.any { it != 0 && it != k }) "NO" else "YES")
}