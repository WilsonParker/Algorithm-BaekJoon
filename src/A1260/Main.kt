package A1260

import java.util.*

fun main() {
    var (n, m, v) = readLine()!!.split(" ").map { it.toInt() - 1 }
    n++
    val dMap = Array(n) { Array(n) { 0 } }
    val bMap = Array(n) { LinkedList<Int>() }
    var dVisit = Array(n) { false }
    var bVisit = Array(n) { false }

    for (i in 0..m) {
        val (f, t) = readLine()!!.split(" ").map { it.toInt() - 1 }
        dMap[f][t] = 1
        dMap[t][f] = 1

        bMap[f].add(t)
    }
    bMap.map { it.sort() }

    fun dfs(s: Int) {
        print("${s + 1} ")
        dVisit[s] = true
        for (i in dMap[s].indices) {
            if (!dVisit[i] && dMap[s][i] == 1)
                dfs(i)
        }
    }

    fun bfs(s: Int) {
        val q = LinkedList<Int>()
        q.offer(s)

        while (!q.isEmpty()) {
            val p = q.pop()
            println("${p + 1} ")
            if (!bVisit[p]) {
                bVisit[p] = true
                for (i in bMap[p]) {
                    q.add(i)
                }
            }
        }
    }

    dfs(v)
    println()
    // println(map.contentDeepToString())
    bfs(v)
}