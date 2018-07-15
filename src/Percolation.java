import edu.princeton.cs.algs4.*;

// Performance requirements.  The constructor should take time proportional to n2; 
// all methods should take constant time plus a constant number of calls to the union–find methods union(), find(), connected(), and count(). 

public class Percolation {

	private boolean[] isOpen;
	private int numOpenSites;
	private int n = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Percolation(int n) // create n-by-n grid, with all sites blocked
	{
		if (n <= 0)
			throw new IllegalArgumentException("Out of range");
		this.n = n;
		isOpen = new boolean[n * n];
	}

	public void open(int row, int col) // open site (row, col) if it is not open already
	{
		if (row <= 0 || row > n)
			throw new IllegalArgumentException("row Out of range");
		if (col <= 0 || col > n)
			throw new IllegalArgumentException("col Out of range");
		if (!isOpen(row, col)) {
			int arrIndex = getArrayIndex(row, col);
			isOpen[arrIndex] = true;
			numOpenSites++;
		}
	}

	public boolean isOpen(int row, int col) // is site (row, col) open?
	{
		if (row <= 0 || row > n)
			throw new IllegalArgumentException("row Out of range");
		if (col <= 0 || col > n)
			throw new IllegalArgumentException("col Out of range");
		return isOpen[getArrayIndex(row, col)];
	}

	public boolean isFull(int row, int col) // is site (row, col) full?
	{
		if (row <= 0 || row > n)
			throw new IllegalArgumentException("row Out of range");
		if (col <= 0 || col > n)
			throw new IllegalArgumentException("col Out of range");
	}

	public int numberOfOpenSites() // number of open sites
	{
		return this.numOpenSites;
	}

	public boolean percolates() // does the system percolate?
	{
	}

	private int getArrayIndex(int row, int col) {
		int actRowIndex = (row - 1);
		int actColIndex = (col - 1);
		return (actRowIndex * this.n) + actColIndex;
	}
}
