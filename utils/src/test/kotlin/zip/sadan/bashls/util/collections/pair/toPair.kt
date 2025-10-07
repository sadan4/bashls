package zip.sadan.bashls.util.collections.pair

fun <T> Collection<T>.toPair(): Pair<T, T> {
    if (size != 2) {
        throw IndexOutOfBoundsException()
    }
    return Pair(first(), last())
}
