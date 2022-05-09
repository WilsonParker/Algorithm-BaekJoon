package A24508

fun main() {
    var (n, k, t) = "2 2 1".split(" ").map { it.toInt() }
    val v = "1 1".split(" ").map { it.toInt() }.sorted().toMutableList()
    println(v)
    // n * k
    var last = v.size - 1
    var r = "YES"
    for (i in v.indices) {
        var tmp = v[i]
        while (tmp < k) {
            if (last > 0 && v[last] > 0) {
                if (t > 0) {
                    v[last] -= 1
                    t -= 1
                    tmp += 1
                } else {
                    r = "NO"
                    println("return")
                    return
                }
            } else {
                last -= 1
            }
        }
        v[i] = 0
    }
    print(r)
}