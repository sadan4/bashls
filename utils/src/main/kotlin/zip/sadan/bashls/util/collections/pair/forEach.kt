package zip.sadan.bashls.util.collections.pair

fun <T> Pair<T, T>.forEach(fn: (T) -> Unit) {
    fn(first)
    fn(second)
}

fun <T> Pair<T, T>.forEachIndexed(fn: (Int, T) -> Unit) {
    fn(0, first)
    fn(1, second)
}
