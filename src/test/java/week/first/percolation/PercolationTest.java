package week.first.percolation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PercolationTest {

    @Test
    public void constructor() {
        try {
            Percolation p = new Percolation(0);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getClass() == IllegalArgumentException.class);
        }
    }

    @Test
    public void open() {
        Percolation p = new Percolation(5);
        p.open(1, 1);
        assertTrue(p.isOpen(1, 1));
        p.open(5, 5);
        assertTrue(p.isOpen(5, 5));

        assertFalse(p.isOpen(1, 5));
    }

    @Test
    public void isFull_straight() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(2, 2);
        p.open(1, 2);

        assertTrue(p.isFull(2, 2));
    }

    @Test
    public void percolates_true() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(2, 2);
        p.open(1, 2);

        assertTrue(p.percolates());
    }

    @Test
    public void percolates_false() {
        Percolation p = new Percolation(3);
        p.open(1, 1);
        p.open(1, 2);

        assertFalse(p.percolates());
    }

    @Test
    public void isFull_secondInFirstRow() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(1, 2);
        assertTrue(p.isOpen(1, 2));
        assertTrue(p.isFull(1, 2));
    }

    @Test
    public void isFull_secondInFirstColumn() {
        Percolation p = new Percolation(2);
        p.open(2, 1);
        p.open(2, 2);
        assertTrue(p.isFull(2,2));
    }
}