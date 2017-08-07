package code.two;

//Follow up for N-Queens problem.
//
//Now, instead outputting board configurations, return the total number of distinct solutions.
public class TotalNQueens {
	public int totalNQueens(int n) {
		if (n < 2) {
			return n;
		}
		char[][] cc = new char[n][n];
		return sovle(cc, n, 0);
	}

	private int sovle(char[][] cc, int n, int i) {
		int qwe = 0;
		for (int j = 0; j < n; j++) {
			char[][] ccc = clone(cc);
			ccc[i][j] = 'Q';
			if (checkQ(ccc, i, j)) {
				if (i == n - 1) {
					return 1;
				}
				qwe += sovle(ccc, n, i + 1);
			}
		}
		return qwe;
	}

	private char[][] clone(char[][] cc) {
		char[][] ccc = cc.clone();
		for (int i = 0; i < ccc.length; i++) {
			ccc[i] = cc[i].clone();
		}
		return ccc;
	}

	public boolean checkQ(char[][] cc, int x, int y) {
		for (int i = 0; i < cc.length; i++) {
			if (cc[x][i] == 'Q' && i != y) {
				return false;
			}
			if (cc[i][y] == 'Q' && i != x) {
				return false;
			}

			if (i != 0 && ((x - i > -1 && y - i > -1 && cc[x - i][y - i] == 'Q')
					|| (x + i < cc.length && y + i < cc.length
							&& cc[x + i][y + i] == 'Q')
					|| (x - i > -1 && y + i < cc.length
							&& cc[x - i][y + i] == 'Q')
					|| (x + i < cc.length && y - i > -1
							&& cc[x + i][y - i] == 'Q'))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new TotalNQueens().totalNQueens(4));
	}
}
