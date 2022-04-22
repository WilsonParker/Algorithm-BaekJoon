package A1260

import java.util.*

fun main() {
    var (n, m, v) = readLine()!!.split(" ").map { it.toInt() - 1 }
    n++
    val dMap = Array(n) { Array(n) { 0 } }
    val bMap = Array(n) { LinkedList<Int>() }
    var dVisit = Array(n) { 0 }
    var bVisit = Array(n) { 0 }

    for (i in 0..m) {
        val (f, t) = readLine()!!.split(" ").map { it.toInt() - 1 }
        dMap[f][t] = 1
        dMap[t][f] = 1

        bMap[f].add(t)
    }
    bMap.map { it.sort() }

    fun dfs(s: Int) {
        print("${s + 1} ")
        dVisit[s] = 1
        for (i in dMap[s].indices) {
            if (dVisit[i] == 0 && dMap[s][i] == 1)
                dfs(i)
        }
    }

    fun bfs(s: Int) {
        val q = LinkedList<Int>()
        q.add(s)
        bVisit[s] = 1

        while (!q.isEmpty()) {
            val p = q.pop()
            println("${p + 1} ")
            for (i in bMap[p]) {
                println("i : $i} ")
                if (bVisit[i] == 0) {
                    q.add(i)
                    bVisit[i] = 1
                }
            }
        }
    }

    dfs(v)
    println()
    // println(map.contentDeepToString())
    bfs(v)
}