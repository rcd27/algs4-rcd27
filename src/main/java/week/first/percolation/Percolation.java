package week.first.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Методы должны быть линейной сложности и линейно обращаться к методам union-find
 */
public class Percolation {

    private final int n;
    private final WeightedQuickUnionUF elements;
    /* 0 - closed, 1 - open, 2 - filled */
    private final int[] states;

    private int openedSites;

    public Percolation(int n) { // сложность: n^2
        if (n > 0) {
            this.n = n;
        } else {
            this.n = 0;
            throw new IllegalArgumentException("n must be grater than 0");
        }

        elements = new WeightedQuickUnionUF(n * n);

        states = new int[n * n]; // все ячейки изначально заблокированы (states.each{it==0})
    }

    /* Открывает ячейку, если та ещё не открыта */
    public void open(int row, int col) {
        checkNums(row, col);
        int currentElement = get(row, col);
        // если ячейка ещё не открыта
        if (states[currentElement] == 0) {
            // открываем ячейку
            states[currentElement] = 1;

            int[] neighbours = getNeighbours(currentElement);
            // если граничит с верхним краем, заполняем
            if (neighbours[2] < 0) {
                states[currentElement] = 2;
            }

            // FIXME: неверно выполняется
            // объединяем с открытыми соседями
            for (int neighbour : neighbours) {
                if (neighbour > 0 && states[neighbour - 1] > 0) {
                    elements.union(neighbour - 1, currentElement);
                    // если один из соседей заполнен, заполняем
                    if (states[neighbour - 1] == 2) {
                        states[currentElement] = 2;
                    }
                }
            }
            openedSites++;
        }
    }

    public boolean isOpen(int row, int col) {
        checkNums(row, col);
        int currentElement = get(row, col);
        return states[currentElement] > 0;
    }

    /* Открытая ячейка, соединённая с верхней гранью через цепь открытых соседей */
    public boolean isFull(int row, int col) {
        checkNums(row, col);
        int currentElement = get(row, col);
        int rootForCurrentElement = elements.find(currentElement);
        return states[rootForCurrentElement] == 2;
    }

    public int numberOfOpenSites() {
        return openedSites;
    }

    /* true, если есть full ячейки в нижнем ряду */
    public boolean percolates() {
        int lastElement = n * n - 1;
        for (int i = lastElement - n; i < lastElement; i++) {
            if (states[i] == 2) {
                return true;
            }
        }
        return false;
    }

    private int get(int row, int column) {
        if (row < 1 || column < 1) {
            throw new IllegalArgumentException("Row/Column number must be between 1 and n");
        }

        int r = n * (row - 1);
        int c = n - (column - 1);
        return n - c + r;
    }

    private int[] getNeighbours(int x) {
        int n1 = x - 1; // сосед слева
        int n2 = x + 1; // сосед справа
        int n3 = x - n; // сосед сверху
        int n4; // сосед снизу
        if (x + n < n * n) {
            n4 = x + n;
        } else {
            n4 = -1;
        }
        return new int[]{n1, n2, n3, n4};
    }

    private void checkNums(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException("Row or column number must be grater than 0");
        }
    }
}
