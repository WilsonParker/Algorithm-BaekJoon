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
            val l1 = board.map { it.clone() }.toTypedArray().clone()
            val l2 = board.map { it.clone() }.toTypedArray().clone()
            val c = fun(l: Array<CharArray>): Int {
                var r = 0
                for (i in a..a + 7) {
                    for (j in b..b + 7) {
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
            val r1 = c(l1)
            l2[a][b] = rc(l2[a][b])
            val r2 = c(l2)
            println("$r1 $r2")
            val r3 = if (r1 > r2) r2 else r1
            min = if (min > r3) r3 else min
        }
    }
    print(min)
}

//BBBBBBBB
//BBBBBBBB
//BBBBBBBB
//BBBBBBBB
//BBBBBBBB
//BBBBBBBB
//BBBBBBBB
//BBBBBBBW