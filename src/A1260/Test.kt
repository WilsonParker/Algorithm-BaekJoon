package A1260

import java.util.*

fun main() {
    var (n, m, v) = readLine()!!.split(" ").map { it.toInt() - 1 }
    n++
    val map = Array(n) { Array(n) { 0 } }
    var visit = Array(n) { 0 }

    for (i in 0..m) {
        val (f, t) = readLine()!!.split(" ").map { it.toInt() - 1 }
        map[f][t] = 1
        map[t][f] = 1
    }

    fun dfs(s: Int) {
        print("${s + 1} ")
        visit[s] = 1
        for (i in map[s].indices) {
            if (visit[i] == 0 && map[s][i] == 1)
                dfs(i)
        }
    }

    fun bfs(s: Int) {
        val q = LinkedList<Int>()
        q.add(s)
        visit[s] = 1

        while (!q.isEmpty()) {
            print("${q.pop() + 1} ")
            for (i in map[s].indices) {
                if (visit[i] == 0) {
                    q.add(i)
                    visit[i] = 1
                }
            }
        }
    }

    dfs(v)
    visit = visit.map { 0 }.toTypedArray()
    println()
    bfs(v)
}