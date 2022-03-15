package A1334

fun main() {
    val input = "1234567890123456789"
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

    return "test"
}