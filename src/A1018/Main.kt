package A1018

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val board = Array(n) {
        readLine()!!.toCharArray()
    }
    val rc = fun(c: Char) = if (c == 'B') 'W' else 'B'
    var min = 64
    for (a in 0..n - 8) {
        for (b in 0..m - 8) {
            val l = board.map { it.clone() }.toTypedArray().clone()
            val c = fun(): Int {
                var r = 0
                for (i in a until a + 8) {
                    for (j in b until b + 8) {
                        if (j > b) {
                            if (l[i][j - 1] == l[i][j]) {
                                l[i][j] = rc(l[i][j])
                                r++
                            }
                        } else if (i > a) {
                            if (l[i - 1][j] == l[i][j]) {
                                l[i][j] = rc(l[i][j])
                                r++
                            }
                        }
                    }
                }
                return r
            }
            val r1 = c()
            l[a][b] = rc(l[a][b])
            val r2 = c()
            val r = if (r1 > r2) r2 else r1
            min = if (min > r) r else min
        }
    }
    print(min)
}