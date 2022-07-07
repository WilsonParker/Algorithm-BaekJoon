package BaekJoon.A10384

fun main() {
    repeat(readLine()!!.toInt()) { c ->
        val l = ('a'..'z').toList()
        val m = readLine()!!.toCharArray().map { it.lowercaseChar() }.filter { l.contains(it) }.groupBy { it }.map { it to it.value.count() }.toMap()
        val r = if (m.keys.count() == 26) m.values.minOf { it } else 0
        println(
            "Case ${c + 1}: " +
                    when (r) {
                        3 -> "Triple pangram!!!"
                        2 -> "Double pangram!!"
                        1 -> "Pangram!"
                        else -> "Not a pangram"
                    }
        )
    }

}