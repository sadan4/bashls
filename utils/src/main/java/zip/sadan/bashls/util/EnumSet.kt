package zip.sadan.bashls.util

import zip.sadan.bashls.util.collections.iterator.EmptyIterator
import kotlin.enums.EnumEntries
import kotlin.enums.enumEntries

private fun <T: Enum<T>> Enum<T>.asFlag() = 1L shl this.ordinal

class EnumSet<T : Enum<T>>() : Set<T> {

    private var flags: Long = 0;

    private var entries: List<T> = emptyList();

    override var size: Int = 0;

    /**
     * Do not use this
     */
    @PublishedApi
    internal constructor(allValues: EnumEntries<T>, values: Array<out T>) : this() {
        if (values.isEmpty()) {
            return;
        }
        flags = values
            .map(Enum<T>::asFlag)
            .reduce(Long::or)
        size = values.size
        entries = allValues
    }

    override fun iterator(): Iterator<T> {
        if (isEmpty()) {
            return EmptyIterator()
        }
        return object : Iterator<T> {

            override fun next(): T {
                TODO("Not yet implemented")
            }

            override fun hasNext(): Boolean {
                TODO("Not yet implemented")
            }

        }
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

    companion object {
        inline operator fun <reified T : Enum<T>> invoke(vararg flags: T): EnumSet<T> {
            return EnumSet(enumEntries<T>(), flags)
        }
    }
}