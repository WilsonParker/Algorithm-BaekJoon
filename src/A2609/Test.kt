package A2609

import kotlin.math.pow

fun main() {
    // val (n, m) = arrayOf(24, 18).map { measure(it) }
    val (n, m) = arrayOf(33, 157).map { measure(it) }
    println(n)
    println(m)
    println(gcd(n, m))
    print(lcm(n, m))
}

private fun measure(n: Int): Map<Int, List<Int>> {
    val l = ArrayList<Int>()
    var tmp = n
    do {
        for (i in 2..n) {
            if (tmp % i == 0) {
                l.add(i)
                tmp /= i
                break
            }
        }
    } while (tmp != 1)
    return l.groupBy { it }
}

private fun gcd(n: Map<Int, List<Int>>, m: Map<Int, List<Int>>): Int {
    var r = 1.0
    for (i in n.keys) {
        val f = n[i]?.size ?: 0
        val t = m[i]?.size ?: 0
        r *= i.toDouble().pow(if (t < f) t else f)
    }
    return r.toInt()
}

private fun lcm(n: Map<Int, List<Int>>, m: Map<Int, List<Int>>): Int {
    var r = 1.0
    n.keys.plus(m.keys).forEach {
        val f = n[it]?.size ?: 0
        val t = m[it]?.size ?: 0
        r *= it.toDouble().pow(if (t > f) t else f)
    }
    return r.toInt()
}