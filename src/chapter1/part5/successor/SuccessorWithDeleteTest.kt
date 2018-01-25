package chapter1.part5.successor

import org.junit.Assert.assertArrayEquals
import org.junit.Test
import kotlin.test.assertEquals

class SuccessorWithDeleteTest {

    @Test
    fun `delete from middle`() {
        val arr = SuccessorWithDelete(5)
        arr.delete(2)
        val expectedArr = intArrayOf(0, 1, 3, 4)
        assertArrayEquals(expectedArr, arr.elements)
    }

    @Test
    fun `delete from start`() {
        val arr = SuccessorWithDelete(5)
        arr.delete(0)
        val expectedArr = intArrayOf(1, 2, 3, 4)
        assertArrayEquals(expectedArr, arr.elements)
    }

    @Test
    fun `delete from end`() {
        val arr = SuccessorWithDelete(5)
        arr.delete(4)
        val expectedArr = intArrayOf(0, 1, 2, 3)
        assertArrayEquals(expectedArr, arr.elements)
    }

    @Test
    fun `successor after delete from middle`() {
        val arr = SuccessorWithDelete(5) // 0 1 2 3 4
        arr.delete(2) // 0 1 3 4
        assertEquals(3, arr.successor(1))
    }

    @Test
    fun `successor after delete from start`() {
        val arr = SuccessorWithDelete(5) // 0 1 2 3 4
        arr.delete(0) // 1 2 3 4
        assertEquals(2, arr.successor(0))
    }

    @Test
    fun `successor after delete from end`() {
        val arr = SuccessorWithDelete(5) // 0 1 2 3 4
        arr.delete(4) // 0 1 2 3
        assertEquals(3, arr.successor(3))
    }
}