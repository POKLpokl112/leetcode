package code.two;

//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//For example,
//Given n = 3,
//
//You should return the following matrix:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
public class GenerateMatrix_normal_fastest {
	public int[][] generateMatrix(int n) {
		if (n == 0) {
			return new int[0][0];
		}

		if (n == 1) {
			int[][] ii = new int[1][1];
			ii[0][0] = 1;
			return ii;
		}

		int[][] ii = new int[n][n];
		int i = 0;
		int a = n - 1;
		int k = 0;
		while (a > i) {
			for (int j = i; j < a; j++) {
				int q = j - i + 1 + k;
				int l = a - i;

				ii[i][j] = q;

				ii[j][a] = l + q;

				ii[a][a - j + i] = l * 2 + q;

				ii[a - j + i][i] = l * 3 + q;
			}

			k += 4 * (a - i);
			i++;
			a--;
		}

		if (n % 2 == 1) {
			ii[n / 2][n / 2] = n * n;
		}
		return ii;
    }
}
