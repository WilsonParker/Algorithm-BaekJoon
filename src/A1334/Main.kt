package A1334

fun main() {
    val input = readLine()!!
    val result = if (input.length == 1) {
        input.toInt() + 1
    } else {
        execute(input)
    }
    print(result)
}

private fun execute(s: String): String {
    val l = s.length;
    val odd = l % 2;
    val half = l / 2;

    val front = s.slice(IntRange(0, half - 1))
    var back = s.slice(IntRange(half + odd, l - 1))

    if (front.first() > back.first()) {
        back = front.reversed()
    } else {
        return execute(inc(s))
    }

    return if (odd == 1) {
        front + s.slice(IntRange(half, half)) + back
    } else {
        front + back
    }
}

private fun inc(s: String): String {
    return if (s.length > 8) {
        inc(s.slice(IntRange(0, 7))) + inc(s.slice(IntRange(7, s.length - 1)))
    } else {
        (s.toInt() + 1).toString()
    }
}