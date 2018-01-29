package week.first.percolation;

public class PercolationStats {

    private final int trials;

    public PercolationStats(int n, int trials) {
        if (n < 0 || n == 0 || trials < 0 || trials == 0) {
            throw new IllegalArgumentException("Number of n and trials must be greater than 0");
        }

        this.trials = trials;
    }

    /* sample mean of percolation threshold */
    public double mean() {
        return 0;
    }

    /* sample standard deviation of percolation threshold */
    public double stddev() {
        if (trials == 1) {
            return Double.NaN;
        }
        return 0;
    }

    /* low endpoint of 95% confidence interval */
    public double confidenceLo() {
        return 0;
    }

    /* high endpoint of 95% confidence interval */
    public double confidenceHi() {
        return 0;
    }

    public static void main(String[] args) {
        // StdStats.mean() for computing sample mean
        // StdStats.stddev() for computing sample dev
    }
}
