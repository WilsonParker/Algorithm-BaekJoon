package A1334

import kotlin.math.pow
import kotlin.math.sign

fun main() {
    var n: String
    n = "12345"
    n = "1999"
    n = "858"
    n = "54"
    n = "45"
    n = "999"
    n = "9999"
    val result = if (n.length == 1)
        n.toInt() + 1
    else {
        var carry = 0
        val l = n.length
        val h = l / 2
        val m = h + l % 2
        println("$h $m")

        var front = n.slice(IntRange(0, m - 1))
        println(front)
        if (sum(n.slice(IntRange(0, h - 1))) <= sum(n.slice(IntRange(m, l - 1)))) {
            val arr = front.toCharArray().map { it.digitToInt() }.toMutableList()
            for (i in arr.size - 1 downTo 0) {
                val temp = arr[i] + 1
                arr[i] = temp % 10
                carry = temp / 10
                if (carry == 0) break;
            }
            front = (if (carry == 1) "1" else "") + arr.joinToString("")
        }

        println(front)
        if (h == m && carry == 0) {
            front + front.reversed()
        } else {
            var m: String
            if (carry == 1) {
                m = front.slice(IntRange(front.length - 2, 1))
                front = front.dropLast(1)
            } else {
                m = front.slice(IntRange(front.length - 1, 1))
                front = front.dropLast(1)
            }
            println(front)
            println(m)
            front + m + front.reversed()
        }
    }
    print(result)
}

private fun sum(s: String): Int = s.toCharArray().mapIndexed { i, c -> c.digitToInt() * 10.0.pow(i) }.sum().toInt()