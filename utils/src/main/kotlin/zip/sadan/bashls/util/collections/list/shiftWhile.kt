package zip.sadan.bashls.util.collections.list

inline fun <T> MutableList<T>.shiftWhile(predicate: (T) -> Boolean): List<T> {
    if (isEmpty()) {
        throw ArrayIndexOutOfBoundsException()
    }

    for (index in 0 until size) {
        if (!predicate(this[index])) {
            return shift(index)
        }
    }

    // if we never hit the predicate, we just swap the lists
    return toList().also {
        clear()
    }
}