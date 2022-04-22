package A1260

fun main() {
    val (n, m, v) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(n + 1) { Array(n + 1) { 0 } }
    val visit = Array(n + 1) { 0 }

    for (i in 1..m) {
        val (f, t) = readLine()!!.split(" ").map { it.toInt() }
        map[f][t] = 1
        map[t][f] = 1
    }
    println(map.contentDeepToString())

    fun dfs(s: Int) {
        println(s)
        visit[s] = 1
        for (i in map[s].indices) {
            if (visit[i] == 0 && map[s][i] == 1)
                dfs(i)
        }
    }

    dfs(1)
}