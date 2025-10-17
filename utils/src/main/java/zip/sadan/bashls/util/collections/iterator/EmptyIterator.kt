package zip.sadan.bashls.util.collections.iterator

class EmptyIterator<out T> : Iterator<T> {
    override fun next(): T = throw NoSuchElementException()

    override fun hasNext(): Boolean = false
}