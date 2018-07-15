import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {

	private int n; // size of grid
	private int trials;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = StdIn.readInt();
		int T = StdIn.readInt();
		PercolationStats instance = new PercolationStats(n,T);
	}

	public PercolationStats(int n, int trials) // perform trials independent experiments on an n-by-n grid
	{
		if (n <= 0 || trials <= 0)
			throw new IllegalArgumentException();
		this.n = n;
		this.trials = trials;
	}

	public double mean() // sample mean of percolation threshold
	{
		return 0;
	}

	public double stddev() // sample standard deviation of percolation threshold
	{
		return 0;
	}

	public double confidenceLo() // low endpoint of 95% confidence interval
	{
		return 0;
	}

	public double confidenceHi() // high endpoint of 95% confidence interval
	{
		return 0;
	}
}
