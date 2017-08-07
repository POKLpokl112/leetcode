package code.one;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
	 public boolean isValidSudoku(char[][] board) {
		Set<Character> row = new HashSet<>();
		Set<Character> col = new HashSet<>();
		Set<Character> cube = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j])) {
					return false;
				}

				if (board[j][i] != '.' && !col.add(board[j][i])) {
					return false;
				}

				int cr = i / 3 * 3 + j % 3;
				int cc = i % 3 * 3 + j / 3;

				if (board[cc][cr] != '.' && !cube.add(board[cc][cr])) {
					return false;
				}
			}
			row.clear();
			col.clear();
			cube.clear();
		}

		return true;
	}

	public boolean qweqwe(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length - 1; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				for (int j2 = j + 1; j2 < board.length; j2++) {
					if (board[i][j] == board[i][j2]) {
						return false;
					}
				}

				}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length - 1; j++) {
				if (board[j][i] == '.') {
					continue;
				}
				for (int j2 = j + 1; j2 < board.length; j2++) {
					if (board[j][i] == board[j2][i]) {
						return false;
					}
					}

				}
			}

		return true;
	 }
}
