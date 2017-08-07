package code.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
//Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//For example,
//There exist two distinct solutions to the 4-queens puzzle:
//
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]

//Follow up for N-Queens problem.
//
//Now, instead outputting board configurations, return the total number of distinct solutions.
public class SolveNQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> list = new ArrayList<>();
		char[][] cc = new char[n][n];
		for (char[] cs : cc) {
			Arrays.fill(cs, '.');
		}
		sovle(list, cc, n, 0);

		return list;
	}

	private void sovle(List<List<String>> list, char[][] cc, int n, int i) {
		for (int j = 0; j < n; j++) {
			char[][] ccc = clone(cc);
			ccc[i][j] = 'Q';
			if (checkQ(ccc, i, j)) {
				if (i == n - 1) {
					List<String> l = new ArrayList<>();
					for (int k = 0; k < ccc.length; k++) {
						l.add(new String(ccc[k]));
					}
					list.add(l);
					return;
				}
				sovle(list, ccc, n, i + 1);
			}
		}
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
		System.out.println(new SolveNQueens().solveNQueens(4));
	}

}
