package zip.sadan.bashls.util.collections.list

/**
 * Removes and returns the first element of the mutable list.
 *
 * @return The first element of the list.
 * @throws NoSuchElementException if the list is empty.
 */
fun <T> MutableList<T>.shift(): T = this.removeFirst()

/**
 * Removes and returns the first [n] elements of the mutable list as a new list.
 *
 * @param n The number of elements to remove from the start of the list.
 * @return A list containing the first [n] elements that were removed.
 * @throws IndexOutOfBoundsException if [n] is greater than the size of the list.
 */
fun <T> MutableList<T>.shift(n: Int) = take(n).also {
    subList(0, n).clear()
}

fun StringBuilder.shift(): Char {
    val ret = this.first()
    this.deleteAt(0);
    return ret;
}

fun StringBuilder.shift(n: Int): String {
    val ret = this.substring(0, n);
    this.delete(0, n)
    return ret;
}