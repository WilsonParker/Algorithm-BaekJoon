package BaekJoon.Common

fun printList(r: List<Array<Int>>) {
    r.forEach { printArray(it) }
}

fun <T> printArray(r: Array<T>) {
    println(r.contentDeepToString())
}

fun <T> printlnArray(r: Array<List<T>>) {
    r.forEach { println(it) }
}

fun <T> printlnArray(r: Array<Array<T>>) {
    r.forEach { printArray(it) }
}

fun printlnArray(r: Array<CharArray>) {
    r.forEach { println("[${it.joinToString(",")}]") }
    println()
}

fun <T> printlnArray(r: Array<T>) {
    r.forEach {
        printlnItem(it)
    }
}

fun <T> printlnArray(r: List<T>) {
    r.forEach {
        printlnItem(it)
    }
}

fun <T> printlnItem(item: T) {
    if (item is CharArray) {
        println(item)
    } else if (item is Array<*>) {
        printArray(item)
    } else {
        println(item)
    }
}