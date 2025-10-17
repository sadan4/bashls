package zip.sadan.bashls.util.collections.list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShiftWhileTest {
    @Test
    fun `shiftWhile removes elements while predicate is true`() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        val removed = list.shiftWhile { it < 4 }

        assertEquals(listOf(1, 2, 3), removed)
        assertEquals(listOf(4, 5), list)
    }

    @Test
    fun `shiftWhile removes no elements when predicate is false for first element`() {
        val list = mutableListOf(5, 1, 2, 3, 4)
        val removed = list.shiftWhile { it < 4 }

        assertEquals(emptyList<Int>(), removed)
        assertEquals(listOf(5, 1, 2, 3, 4), list)
    }

    @Test
    fun `shiftWhile removes all elements when predicate is always true`() {
        val list = mutableListOf(1, 2, 3)
        val removed = list.shiftWhile { it < 10 }

        assertEquals(listOf(1, 2, 3), removed)
        assertEquals(emptyList<Int>(), list)
    }

    @Test
    fun `shiftWhile throws exception on empty list`() {
        val list = mutableListOf<Int>()

        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            list.shiftWhile { it < 10 }
        }
    }

    @Test
    fun `shiftWhile works with single element list - predicate true`() {
        val list = mutableListOf(5)
        val removed = list.shiftWhile { it < 10 }

        assertEquals(listOf(5), removed)
        assertEquals(emptyList<Int>(), list)
    }

    @Test
    fun `shiftWhile works with single element list - predicate false`() {
        val list = mutableListOf(15)
        val removed = list.shiftWhile { it < 10 }

        assertEquals(emptyList<Int>(), removed)
        assertEquals(listOf(15), list)
    }

    @Test
    fun `shiftWhile works with string elements`() {
        val list = mutableListOf("a", "b", "c", "d")
        val removed = list.shiftWhile { it < "c" }

        assertEquals(listOf("a", "b"), removed)
        assertEquals(listOf("c", "d"), list)
    }

    @Test
    fun `shiftWhile preserves original list when predicate never matches`() {
        val list = mutableListOf(10, 20, 30)
        val removed = list.shiftWhile { it < 5 }

        assertEquals(emptyList<Int>(), removed)
        assertEquals(listOf(10, 20, 30), list)
    }
}