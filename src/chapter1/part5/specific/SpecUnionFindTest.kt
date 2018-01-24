package chapter1.part5.specific

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SpecUnionFindTest {
    var spec = SpecUnionFind(5)

    @Before
    fun set_up() {
        spec.union(0, 4)
        spec.union(0, 1)
        spec.union(3, 1)
        spec.union(2, 3)
        spec.union(2, 1)
        assertTrue(spec.connected(0, 4))
    }

    @Test
    fun `main test case`() {
        assertEquals(4, spec.max(2))
    }
}