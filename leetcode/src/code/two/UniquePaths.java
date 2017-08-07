package code.two;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?
//
//
//Above is a 3 x 7 grid. How many possible unique paths are there?
//
//Note: m and n will be at most 100.
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		return 1;
	}

	public int movex(int m, int n) {
		int[][] ii = new int[m][n];

		for (int i = 0; i < m; i++) {
			ii[i][0] = 1;
		}

		for (int i = 0; i < n; i++) {
			ii[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				ii[i][j] = ii[i - 1][j] + ii[i][j - 1];
			}
		}

		return ii[m - 1][n - 1];
	}

	public boolean isEnd(int m, int n) {
		if (m == 0 && n == 0) {
			return true;
		}
		return false;
	}

	class Q {
		int a, b;

		public Q(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public boolean isEnd() {
			if (a == 0 && b == 0) {
				return true;
			}

			return false;
		}
	}
}
