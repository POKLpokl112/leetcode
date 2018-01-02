package code.two;

//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//

public class SetZeroes_shoot_1times_speedbyme {
	public void setZeroes(final int[][] matrix) {
		final boolean[] rows = new boolean[matrix.length];
		final boolean[] columns = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}

		}

		for (int j = 0; j < columns.length; j++) {
			if (columns[j]) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 0; j < rows.length; j++) {
			if (rows[j]) {
				for (int i = 0; i < matrix[0].length; i++) {
					matrix[j][i] = 0;
				}
			}
		}

	}
}

// boolean fr = false, fc = false;for(
// int i = 0;i<matrix.length;i++)
// {
// for(int j = 0; j < matrix[0].length; j++) {
// if(matrix[i][j] == 0) {
// if(i == 0) {
// fr = true;
// }
// if(j == 0) {
// fc = true;
// }
// matrix[0][j] = 0;
// matrix[i][0] = 0;
// }
// }
// }
// for(int i = 1; i < matrix.length; i++) {
// for(int j = 1; j < matrix[0].length; j++) {
// if(matrix[i][0] == 0 || matrix[0][j] == 0) {
// matrix[i][j] = 0;
// }
// }
// }
// if(fr) {
// for(int j = 0; j < matrix[0].length; j++) {
// matrix[0][j] = 0;
// }
// }
// if(fc) {
// for(int i = 0; i < matrix.length; i++) {
// matrix[i][0] = 0;
// }
// }
