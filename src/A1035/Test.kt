package A1035

import kotlin.math.abs
import kotlin.math.min

private lateinit var board: Array<Array<Int>>

fun main() {
    val piece = ArrayList<Pair<Int, Int>>()
    for (y in 0..4) {
        val l = readLine()!!.toCharArray()
        for (x in 0..4)
            if (l[x] == '*')
                piece.add(Pair(y, x))
    }

    var result = Int.MAX_VALUE
    for (x in piece.indices) {
        board = Array(5) { Array(5) { 0 } }
        board[piece[x].first][piece[x].second] = 1
        piece.forEachIndexed { index, i ->
            if (index != x) {
                move(i, piece[x])
                println(board.contentDeepToString())
            }
        }
        result = min(result, board.sumOf { it.sum() } - piece.size)
        println("---")
    }
    print(result)
}

private fun move(i: Pair<Int, Int>, target: Pair<Int, Int>) {
    val f = abs(target.first - i.first)
    val s = abs(target.second - i.second)

    println("$target $i")
    println("$f $s")

    // 0.0 0.4
    // 0 4

    if (board[target.first][target.second] == 0)
        board[target.first][target.second] = f + s + 1
    else {
        val target2 =
            if (f > s)
                Pair(
                    if (target.first > i.first) target.first - 1 else target.first + 1,
                    target.second
                )
            else if (f == s)
                Pair(
                    if (target.first > i.first) target.first - 1 else target.first + 1,
                    if (target.second > i.second) target.second - 1 else target.second + 1,
                )
            else
                Pair(
                    target.first,
                    if (target.second > i.second) target.second - 1 else target.second + 1,
                )
        move(
            i,
            target2
        )
    }

//    0 0 0 0 0
//    0 0 0 0 0
//    0 0 0 0 0
//    0 * * 0 0
//    0 * 0 0 0
}