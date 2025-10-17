package zip.sadan.bashls.util.collections.list

fun <T> List<T>.asPair(): Pair<T, T> {
    if (size != 2) {
        error("list must have size to to convert to pair. got size: $size")
    }
    return first() to last()
}