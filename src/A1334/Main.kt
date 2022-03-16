package A1334

fun main() {
    var input = readLine()!!
    val result = if (input.length == 1) {
        input.toInt() + 1
    } else {
        var l = input.length;
        val b = l % 2 + l / 2
        if (input.slice(IntRange(0, 0)).toInt() <= input.slice(IntRange(b, b)).toInt()) {
            val arr = input.toCharArray().map { it.digitToInt() }.toMutableList()
            var carry = 0;
            for (i in l / 2 downTo 0) {
                val temp = arr[i] + 1
                arr[i] = temp % 10
                carry = temp / 10
                if (carry == 0) break;
            }
            input = (if (carry == 1) "1" else "") + arr.joinToString("")
        }

        l = input.length
        val front = input.slice(IntRange(0, l / 2 - 1))
        val mid = if (l % 2 == 1) input.slice(IntRange(l / 2, l / 2)) else ""
        front + mid + front.reversed()
    }
    print(result)
}