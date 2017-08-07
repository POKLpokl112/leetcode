package code.one;

public class SolveSudoku_cheat {
	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		sov(board);
	}

	private boolean sov(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					for (char k = '1'; k <= '9'; k++) {
						if (isValid(board, k, i, j)) {
							board[i][j] = k;
							if (sov(board)) {
								return true;
							} else {
								board[i][j] = '.';
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, char c, int i, int j) {
		for (int k = 0; k < board.length; k++) {
			if (board[i][k] == c)
				return false;
			if (board[k][j] == c)
				return false;

			int cr = i / 3 * 3 + k % 3;
			int cc = j / 3 * 3 + k / 3;

			if (board[cr][cc] == c) {
				return false;
			}

		}

		return true;
	}

	public boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {// trial. Try 1 through 9
						if (isValid(board, i, j, c)) {
							board[i][j] = c; // Put c for this cell

							if (solve(board))
								return true; // If it's the solution return true
							else
								board[i][j] = '.'; // Otherwise go back
						}
					}

					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.' && board[i][col] == c)
				return false; // check row
			if (board[row][i] != '.' && board[row][i] == c)
				return false; // check column
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
					&& board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
				return false; // check 3*3 block
		}
		return true;
	}
}
