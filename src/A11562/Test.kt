package A11562

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(n) { Array(3) { "" } }

    printArr(arr)
    println("-----")
    for (i in 0..m) {
        arr[i].plus(readLine()!!.split(" "))
    }
    println("-----")
    printArr(arr)

//    0001
//    0010
//    0110
//    1000
//
//    1 1 0
//    1 2 0
//    2 1 1
//    1 4 0
//    4 1 2
//    2 3 0
//    4 3 1
}

private fun printArr(arr: Array<Array<String>>) {
    arr.forEach { println(it.contentDeepToString()) }
}