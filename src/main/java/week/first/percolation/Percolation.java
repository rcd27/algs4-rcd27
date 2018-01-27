package week.first.percolation;

/**
 * Методы должны быть линейной сложности и линейно обращаться к методам union-find
 */
public class Percolation {

    private final int n;
    private final int[] elements;

    public Percolation(int n) { // сложность: n^2
        if (n > 0) {
            this.n = n;
        } else {
            this.n = 0;
            throw new IllegalArgumentException("n must be grater than 0");
        }

        elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = i;
        }
    }

    /* Открывает ячейку, если та ещё не открыта */
    public void open(int i, int j) {
        //
    }

    public boolean isOpen(int row, int col) {
        return false;
    }

    /* Открытая ячейка, соединённая с верхней гранью через цепь открытых соседей */
    public boolean isFull(int row, int col) {
        return false;
    }

    public int numberOfOpenSites() {
        return 0;
    }

    /* true, если есть full ячейки в нижнем ряду */
    public boolean percolates() {
        return false;
    }

    // TODO убрать эти методы / скрыть видимость в private (если они вообще нужны)
    protected int get(int row, int column) {
        if (row < 1 || column < 1) {
            throw new IllegalArgumentException("Row/Column number must be between 1 and n");
        }

        int r = n * (row - 1);
        int c = n - (column - 1);
        return n - c + r;
    }

    protected boolean neighbours(int x, int y) {
        int n1 = x - 1;
        int n2 = x + 1;
        int n3 = x - n;
        int n4 = x + n;
        return y == n1 || y == n2 || y == n3 || y == n4;
    }
}
