package zip.sadan.bashls.bash.lexer

import zip.sadan.bashls.util.collections.list.asPair
import kotlin.collections.windowed

data class Range(val start: Int, val length: Int) {
    val end = start + length

    // TODO: add tests
    fun contiguousWith(vararg others: Range?): Range = contiguous(this, *others)

    companion object {
        fun contiguous(vararg ranges: Range?): Range {
            val allRanges = ranges
                .toList()
                .filterNotNull()
                .sortedBy(Range::start)
            allRanges
                .windowed(2)
                .map(List<Range>::asPair)
                .forEach {
                    if (it.first.end != it.second.start) {
                        error("ranges must be contiguous")
                    }
                }
            return Range(allRanges.first().start, allRanges.sumOf(Range::length))
        }
    }
}