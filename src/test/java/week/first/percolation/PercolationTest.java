package week.first.percolation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PercolationTest {

    @Test
    public void isOpen_normal() {
        Percolation p = new Percolation(2);
        p.open(2, 2);
        assertTrue(p.isOpen(2, 2));

        assertFalse(p.isOpen(2, 1));
        assertFalse(p.isOpen(1, 2));
        assertFalse(p.isOpen(1, 1));
    }

    @Test
    public void isFull_first_row() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        assertTrue(p.isFull(1, 1));
    }

    @Test
    public void isFull_after_transitive_opening() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(2, 2);
        p.open(2, 1);
        assertTrue(p.isFull(2, 2));
    }
}