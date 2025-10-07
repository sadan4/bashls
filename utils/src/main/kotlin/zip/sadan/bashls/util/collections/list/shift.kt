package zip.sadan.bashls.util.collections.list

fun <T> MutableList<T>.shift(): T = this.removeFirst()
fun <T> MutableList<T>.shift(n: Int) = take(n).also {
    subList(0, n).clear()
}

