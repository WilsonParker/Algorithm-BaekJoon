package BaekJoon.A1334

import kotlin.math.pow
import kotlin.test.assertEquals

fun main() {
    assertEquals(test("12345"), "12421")
    assertEquals(test("858"), "868")
    assertEquals(test("1999"), "2002")
    assertEquals(test("1"), "2")
    assertEquals(test("9999"), "10001")

    assertEquals(test("2"), "3")
    assertEquals(test("9"), "11")
    assertEquals(test("11"), "22")
    assertEquals(test("111"), "121")
    assertEquals(test("1111"), "1221")
    assertEquals(test("98"), "99")
    assertEquals(test("100"), "101")
    assertEquals(test("54"), "55")
    assertEquals(test("45"), "55")
    assertEquals(test("201"), "202")
    assertEquals(test("209"), "212")
    assertEquals(test("299"), "303")
    assertEquals(test("54321"), "54345")
    assertEquals(test("55555"), "55655")
    assertEquals(test("100"), "101")
    assertEquals(test("3999993"), "4000004")
    assertEquals(test("909"), "919")
    assertEquals(test("999"), "1001")
    assertEquals(test("898"), "909")
    assertEquals(test("989"), "999")
    assertEquals(test("9899"), "9999")
    assertEquals(test("9989"), "9999")
    assertEquals(test("10000000000000000000000000000000000000000000000000"), "10000000000000000000000000000000000000000000000001")
    assertEquals(test("99999999999999999999999998999999999999999999999999"), "99999999999999999999999999999999999999999999999999")
    assertEquals(test("99999999999999999999999999999999999999999999999999"), "100000000000000000000000000000000000000000000000001")
}

private fun test(input: String): String {
    var n = input
    val result = if (n.length == 1 && n.toInt() < 9)
        "${n.toInt() + 1}"
    else {
        if (n.length == 1)
            n = "10"
        val l = n.length
        val h = l / 2
        val o = l % 2
        var carry = 0

        var front = n.slice(IntRange(0, h - 1))
        var back = n.slice(IntRange(h + o, l - 1))
        var mid = n.slice(IntRange(h, h + o - 1))

        // if (sum(front.reversed()) <= sum(back)) {
        if (front.reversed().toDouble() <= back.toDouble()) {
            val arr = (front + mid).toCharArray().map { it.digitToInt() }.toMutableList()
            for (i in arr.size - 1 downTo 0) {
                val temp = arr[i] + 1
                arr[i] = temp % 10
                carry = temp / 10
                if (carry == 0) break;
            }

            if (o == 1) {
                mid = arr[arr.size - 1].toString()
                arr.removeAt(arr.size - 1)
            }

            if (carry == 1) {
                mid += arr[arr.size - 1].toString()
                arr.removeAt(arr.size - 1)
            }
            front = (if (carry == 1) "1" else "") + arr.joinToString("")
        }

        front + mid + front.reversed()
    }
    println(result)
    return result
}

private fun sum(s: String): Int = s.toCharArray().mapIndexed { i, c -> c.digitToInt() * 10.0.pow(i) }.sum().toInt()