package A1015

fun main(){
    readLine()
    val l=readLine()!!.split(' ').mapIndexed{i,s->A(s.toInt(),i)}
    l.sortedBy{it.n}.forEachIndexed{i,s->s.j=i}
    l.forEach{print("${it.j} ")}
}
data class A(val n:Int,val i:Int){var j=0}