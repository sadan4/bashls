package zip.sadan.bashls.util.collections.pair

fun <T, R> Pair<T, T>.map(fn: (T) -> R): Pair<R, R> = Pair(fn(first), fn(second))