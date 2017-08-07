package code.two;

import java.util.ArrayList;
import java.util.List;

//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//For example,
//Given the following matrix:
//
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//You should return [1,2,3,6,9,8,7,4,5].
public class SpiralOrder {


	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0) {
			return new ArrayList<>();
		}
		List<Integer> list = new ArrayList<>();
		int i = 0;
		int rowL = matrix.length - 1;
		int colL = matrix[0].length - 1;
		while (rowL > 2 * i && colL > 2 * i) {
			for (int j = i; j < colL - i; j++) {
				list.add(matrix[i][j]);
			}

			for (int j = i; j < rowL - i; j++) {
				list.add(matrix[j][colL - i]);
			}

			for (int j = colL - i; j > i; j--) {
				list.add(matrix[rowL - i][j]);
			}

			for (int j = rowL - i; j > i; j--) {
				list.add(matrix[j][i]);
			}
			i++;
		}

		if (rowL == 2 * i) {
			for (int j = i; j <= colL - i; j++) {
				list.add(matrix[i][j]);
			}
		} else if (colL == 2 * i) {
			for (int j = i; j <= rowL - i; j++) {
				list.add(matrix[j][colL - i]);
			}
		}


		return list;

	}

	public List<Integer> asd(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();

		if (matrix.length == 0) {
			return res;
		}

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// Traverse Right
			for (int j = colBegin; j <= colEnd; j++) {
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			// Traverse Down
			for (int j = rowBegin; j <= rowEnd; j++) {
				res.add(matrix[j][colEnd]);
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// Traverse Left
				for (int j = colEnd; j >= colBegin; j--) {
					res.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// Traver Up
				for (int j = rowEnd; j >= rowBegin; j--) {
					res.add(matrix[j][colBegin]);
				}
			}
			colBegin++;
		}

		return res;
	}
}
