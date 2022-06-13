package BaekJoon.A11285

import kotlin.test.assertEquals

fun main() {
    assertEquals(test(arrayOf('ㄴ', 'ㅏ')), '나')
    assertEquals(test(arrayOf('ㄷ', 'ㅏ')), '다')
}

private fun test(c: Array<Char>): Char {
    val x = arrayOf('ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')
    val r = x.indexOf(c[0]) * 1176 + c[1].code - 12623 + 44032;
    (12593..12622).forEach {
        // println(it.toChar())
    }

    // 초 12593..12622
    // 중 12623..12643
    // 종 44032..
    // 18816
    // 가 - 나 = 1176

    println(x.indexOf(c[0]))
    println(c[0].code)
    println(c[1].code)
    println(('ㄴ'.code - 12593) * 1176 + 'ㅏ'.code - 12623 + 44032)
    println(r)
    println(r - '다'.code)
    return r.toChar()
}
