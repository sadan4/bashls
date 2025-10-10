package zip.sadan.bashls.util.collections.list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShiftTest {
    @Test
    fun `shift() removes and returns first element`() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        val shifted = list.shift()

        assertEquals(1, shifted)
        assertEquals(listOf(2, 3, 4, 5), list)
    }

    @Test
    fun `shift() works with single element list`() {
        val list = mutableListOf(42)
        val shifted = list.shift()

        assertEquals(42, shifted)
        assertEquals(emptyList<Int>(), list)
    }

    @Test
    fun `shift() throws exception on empty list`() {
        val list = mutableListOf<Int>()

        assertThrows(NoSuchElementException::class.java) {
            list.shift()
        }
    }

    @Test
    fun `shift() works with different types`() {
        val list = mutableListOf("hello", "world", "test")
        val shifted = list.shift()

        assertEquals("hello", shifted)
        assertEquals(listOf("world", "test"), list)
    }

    @Test
    fun `shift(n) removes and returns first n elements`() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        val shifted = list.shift(3)

        assertEquals(listOf(1, 2, 3), shifted)
        assertEquals(listOf(4, 5), list)
    }

    @Test
    fun `shift(n) with n=0 returns empty list and leaves original unchanged`() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        val shifted = list.shift(0)

        assertEquals(emptyList<Int>(), shifted)
        assertEquals(listOf(1, 2, 3, 4, 5), list)
    }

    @Test
    fun `shift(n) with n=1 behaves like single shift`() {
        val list = mutableListOf(10, 20, 30)
        val shifted = list.shift(1)

        assertEquals(listOf(10), shifted)
        assertEquals(listOf(20, 30), list)
    }

    @Test
    fun `shift(n) with n equal to list size removes all elements`() {
        val list = mutableListOf(1, 2, 3)
        val shifted = list.shift(3)

        assertEquals(listOf(1, 2, 3), shifted)
        assertEquals(emptyList<Int>(), list)
    }

    @Test
    fun `shift(n) with n greater than list size throws IndexOutOfBoundsException`() {
        val list = mutableListOf(1, 2)

        assertThrows(IndexOutOfBoundsException::class.java) {
            list.shift(5)
        }
    }

    @Test
    fun `shift(n) throws IndexOutOfBoundsException on empty list with positive n`() {
        val list = mutableListOf<Int>()

        assertThrows(IndexOutOfBoundsException::class.java) {
            list.shift(3)
        }
    }

    @Test
    fun `shift(n) works with string elements`() {
        val list = mutableListOf("a", "b", "c", "d", "e")
        val shifted = list.shift(2)

        assertEquals(listOf("a", "b"), shifted)
        assertEquals(listOf("c", "d", "e"), list)
    }

    @Test
    fun `shift(n) with negative n throws IllegalArgumentException`() {
        val list = mutableListOf(1, 2, 3)

        assertThrows(IllegalArgumentException::class.java) {
            list.shift(-1)
        }
    }
}