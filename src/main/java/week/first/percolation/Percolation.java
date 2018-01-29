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

            for (int neighboor : neighbours) {
                if (neighboor == -1) {
                    states[currentElement] = 2;
                }
                if (neighboor >= 0 && neighboor < n * n) {
                    // Если сосед открыт, объеденить элемент с соседом.
                    if (states[neighboor] == 1) {
                        elements.union(currentElement, neighboor);
                    }
                    // Если сосед заполнен, заполнить элемент и объеденить с соседом
                    if (states[neighboor] == 2) {
                        states[currentElement] = 2;
                        elements.union(neighboor, currentElement);
                    }
                    // Если корень соседа открыт, а текущий элемент заполнен, заполнить корень соседа
                    if (states[elements.find(neighboor)] == 1 &&
                            states[currentElement] == 2) {
                        states[elements.find(neighboor)] = 2;
                    }
                }
            }

            openedSites++;
        }
    }

    public boolean isOpen(int row, int col) {
        checkNums(row, col);
        int currentElement = get(row, col);
        return states[currentElement] >= 1;
    }

    /* Открытая ячейка, соединённая с верхней гранью через цепь открытых соседей */
    public boolean isFull(int row, int col) {
        checkNums(row, col);
        int currentElement = get(row, col);
        int root = elements.find(currentElement);
        return states[root] == 2;
    }

    public int numberOfOpenSites() {
        return openedSites;
    }

    /* true, если есть full ячейки в нижнем ряду */
    public boolean percolates() {
        int lastElement = n * n - 1;
        for (int i = lastElement - n; i < lastElement; i++) {
            if (states[elements.find(i)] == 2) {
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
        // сосед слева
        int n1;
        if (x % n != 0) {
            n1 = x - 1;
        } else {
            n1 = -100;
        }

        // сосед справа
        int n2;
        if (x % n != 0) {
            n2 = x + 1;
        } else {
            n2 = -100;
        }

        // сосед сверху
        int n3;
        if (x - n >= 0) {
            n3 = x - n;
        } else {
            n3 = -1;
        }

        // сосед снизу
        int n4;
        if (x + n < n * n) {
            n4 = x + n;
        } else {
            n4 = -100;
        }
        return new int[]{n1, n2, n3, n4};
    }

    private void checkNums(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException("Row or column number must be grater than 0");
        }
    }
}
