package A1334

import kotlin.math.pow
import kotlin.math.sign

fun main() {
    var n: String
    n = "129"
    n = "858"
    n = "12345"
    n = "54321"
    n = "54"
    n = "45"
    n = "999"
    n = "1999"
    n = "9999"
    n = "123456789012345678901234567890"
    val result = if (n.length == 1)
        n.toInt() + 1
    else {
        // 길이
        val l = n.length
        // 가운데 위치
        val h = l / 2
        // 홀수 여부
        val o = l % 2
        // 올림 값
        var carry = 0
        var front = n.slice(IntRange(0, h - 1 + o))
        println("front : $front")
        if (sum(n.slice(IntRange(0, h - 1))) <= sum(n.slice(IntRange(h + o, l - 1)))) {
            val arr = front.toCharArray().map { it.digitToInt() }.toMutableList()
            for (i in arr.size - 1 downTo 0) {
                val temp = arr[i] + 1
                arr[i] = temp % 10
                carry = temp / 10
                if (carry == 0) break;
            }
            front = (if (carry == 1) "1" else "") + arr.joinToString("")
        }

        println("front2 : $front")
        println("carry : $carry")
        println("o : $o")
        val a = if (carry == 1) front.last() else ""
        val b = if (o == 1) front.last() else ""
        front = front.dropLast(carry + o)
        println("front3 : $front")
        front + a + b + front.reversed()
    }
    print(result)
}

private fun sum(s: String): Int = s.toCharArray().mapIndexed { i, c -> c.digitToInt() * 10.0.pow(i) }.sum().toInt()