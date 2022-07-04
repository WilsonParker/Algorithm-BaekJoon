package BaekJoon.A10798

fun main() {
    val b = Array(5) { readLine()!! }.map { it.padEnd(15, '_').toCharArray() }
    for (i in 0..14)
        for (j in 0..4)
            if (b[j][i] != '_')
                print(b[j][i])
}