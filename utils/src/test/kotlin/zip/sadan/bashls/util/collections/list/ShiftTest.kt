package zip.sadan.bashls.util.collections.list

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class ShiftTest {
    @Test
    fun shift() {
        val list = (0..10).toMutableList();
        for (i in 0..10) {
            assertEquals(list.shift(), i)
        }
        assertEquals(list.size, 0);
        assertThrows(NoSuchElementException::class.java) {
            list.shift()
        }
    }

    @Test
    fun shiftInt() {
        val list = (0..10).toMutableList()
        for (i in (0..10).chunked(2)) {
            assertEquals(list.shift(2), i)
        }
        assertEquals(list.size, 0);
        assertThrows(NoSuchElementException::class.java) {
            list.shift(2)
        }
    }

}