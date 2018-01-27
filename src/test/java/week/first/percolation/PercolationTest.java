package week.first.percolation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PercolationTest {

    @Test
    public void getTest() {
        Percolation p = new Percolation(4);
        assertEquals(0, p.get(1, 1));
        assertEquals(3, p.get(1, 4));
        assertEquals(5, p.get(2, 2));
        assertEquals(15, p.get(4, 4));
    }

    @Test
    public void neighboursTest() {
        Percolation p = new Percolation(4);
        assertTrue(p.neighbours(0, 4));
        assertFalse(p.neighbours(0, 5));

        assertTrue(p.neighbours(6, 5));
        assertTrue(p.neighbours(6, 7));
        assertTrue(p.neighbours(6, 2));
        assertTrue(p.neighbours(6, 10));
    }
}
