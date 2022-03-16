package A1334

import kotlin.math.pow

fun main() {
    val n = readLine()!!
    val result = if (n.length == 1)
        n.toInt() + 1
    else {
        var front: String
        val l = n.length
        val h = l / 2
        val m = h + l % 2
        val c = if (l == 2) -1 else 0

        if (sum(n.slice(IntRange(0, h - 1))) <= sum(n.slice(IntRange(m, l - 1)))) {
            val arr = n.slice(IntRange(0, h + c)).toCharArray().map { it.digitToInt() }.toMutableList()
            var carry = 0;
            for (i in arr.size - 1 downTo 0) {
                val temp = arr[i] + 1
                arr[i] = temp % 10
                carry = temp / 10
                if (carry == 0) break;
            }
            front = (if (carry == 1) "1" else "") + arr.joinToString("")
        } else {
            front = n.slice(IntRange(0, h + c))
        }

        if (l == 2) {
            front + front.reversed()
        } else {
            val m = front.last()
            front = front.dropLast(1)
            front + m + front.reversed()
        }
    }
    print(result)
}

private fun sum(s: String): Int = s.toCharArray().mapIndexed { i, c -> c.digitToInt() * 10.0.pow(i) }.sum().toInt()