package zip.sadan.bashls.util.collections.pair

inline fun <T> Pair<T, T>.all(predicate: (T) -> Boolean): Boolean = predicate(first) && predicate(second)
fun <T> Pair<T, T>.all(value: T): Boolean = first == value && second == value