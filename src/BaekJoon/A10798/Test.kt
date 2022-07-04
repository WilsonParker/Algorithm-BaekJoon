package BaekJoon.A10798

import kotlin.test.assertEquals

fun main() {
    assertEquals(
        test(
            arrayOf(
                "ABCDE",
                "abcde",
                "01234",
                "FGHIJ",
                "fghij",
            )
        ), "Aa0FfBb1GgCc2HhDd3IiEe4Jj"
    )

    assertEquals(
        test(
            arrayOf(
                "AABCDD",
                "afzz",
                "09121",
                "a8EWg6",
                "P5h3kx",
            )
        ), "Aa0aPAf985Bz1EhCz2W3D1gkD6x"
    )
}

private fun test(input: Array<String>): String {
    val b = input.map { it.padEnd(15, '_').toCharArray() }
    // printlnArray(b)
    var r = ""
    for (i in 0..14) {
        for (j in 0..4) {
            if (b[j][i] != '_') {
                r += b[j][i]
            }
        }
    }
    return r
}