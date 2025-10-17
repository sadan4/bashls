package zip.sadan.bashls.util.collections.iterator

private typealias I<T> = Iterator<T>

inline fun <T, R> I<T>.lazilyMap(crossinline mapper: (T) -> R): I<R> {
    return object : I<R> {
        override fun hasNext() = this@lazilyMap.hasNext()
        override fun next(): R = mapper(this@lazilyMap.next())
    }
}

inline fun <T> I<T>.lazilyFilter(crossinline predicate: (T) -> Boolean): I<T> {
    return object : I<T> {
        private var hn: Boolean = false;
        private var n: T? = null
        override fun next(): T {
            if (hn) {
                hn = false;
                @Suppress("UNCHECKED_CAST")
                return n as T;
            }
        }

        override fun hasNext(): Boolean {
            if (!this@lazilyFilter.hasNext()) {
                return false;
            }
            var maybeNext = this@lazilyFilter.next();
            while (!predicate(maybeNext)) {
                if (!this@lazilyFilter.hasNext()) {
                    return false;
                }
                maybeNext = this@lazilyFilter.next()
            }
            hn = true;
            n = maybeNext;
            return true;
        }
    }
}