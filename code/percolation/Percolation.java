/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int size;
    private int openSites;
    private int TOP;
    private int BOTTOM;
    private final WeightedQuickUnionUF uf;
    private boolean[][] opened;


    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        size = n;
        opened = new boolean[n][n];
        uf = new WeightedQuickUnionUF(size * size + 2);
        openSites = 0;
        TOP = 0;
        BOTTOM = size * size + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkVaild(row, col);
        // open current site
        opened[row - 1][col - 1] = true;
        openSites++;

        // if row == 1
        // union it to the top site
        if (row == 1) {
            uf.union(getUnionIndex(row, col), TOP);
        }
        // if row = size
        // union to the bottom
        if (row == size) {
            uf.union(getUnionIndex(row, col), BOTTOM);
        }
        // if in the middle
        // to see if its neighbor(4 positions) is opened ?
        // if is opened, then union it to its neighbor

        // top check
        if (row > 1 && isOpen(row - 1, col)) {
            uf.union(getUnionIndex(row, col), getUnionIndex(row - 1, col));
        }
        // bottom check
        if (row < size && isOpen(row + 1, col)) {
            uf.union(getUnionIndex(row, col), getUnionIndex(row + 1, col));
        }
        // left check
        if (col > 1 && isOpen(row, col - 1)) {
            uf.union(getUnionIndex(row, col), getUnionIndex(row, col - 1));
        }
        // right check
        if (col < size && isOpen(row, col + 1)) {
            uf.union(getUnionIndex(row, col), getUnionIndex(row, col + 1));
        }

    }

    private int getUnionIndex(int row, int col) {
        return size * (row - 1) + col;
    }

    /**
     * to check if the input value of row and col is valid
     *
     * @param row
     * @author ylyin
     * @version 1.0.0
     */
    public void checkVaild(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) {
            throw new IllegalArgumentException("Invaild Value!");
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkVaild(row, col);
        return opened[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if ((row > 0 && row <= size) && (col > 0 && col <= size)) {
            return uf.find(getUnionIndex(row, col)) == uf.find(TOP);
        }
        else {
            throw new IllegalArgumentException("Invaild Value!");
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        // to check if the top is connected to the bootom
        return uf.find(TOP) == uf.find(BOTTOM);
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        Percolation percolation = new Percolation(n);
        while (!percolation.percolates()) {
            int raw = StdRandom.uniformInt(1, n + 1);
            int col = StdRandom.uniformInt(1, n + 1);
            if (!percolation.isOpen(raw, col)) {
                percolation.open(raw, col);
            }
        }
        StdOut.println("percolation number : " + percolation.openSites);
    }
}
