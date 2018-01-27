package week.first.unionfind

import org.junit.Assert.*
import org.junit.Test


class UnionFindTest {

    @Test
    fun `root() no trees test`() {
        val uf = UnionFind(10)
        for (i in 0 until 9) {
            assertEquals(i, uf.root(i))
        }
    }

    @Test
    fun `weighted quick-union demo test`() {
        val uf = UnionFind(10)

        uf.union(4, 3)
        uf.union(3, 8)
        assertTrue(uf.connected(8, 4))

        uf.union(6, 5)
        uf.union(9, 4)
        uf.union(2, 1)
        uf.union(5, 0)
        assertTrue(uf.connected(0, 6))

        uf.union(7, 2)
        uf.union(6, 1)
        assertTrue(uf.connected(6, 2))

        uf.union(7, 3)
        assertTrue(uf.connected(9, 1))

        assertArrayEquals(intArrayOf(6, 2, 6, 4, 6, 6, 6, 2, 4, 4), uf.elements)
    }
}