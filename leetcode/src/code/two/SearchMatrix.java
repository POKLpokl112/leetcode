package code.two;

//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//For example,
//
//Consider the following matrix:
//
//[
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//Given target = 3, return true.

public class SearchMatrix {
	public boolean searchMatrix(final int[][] matrix, final int target) {

		int min = 0, max = matrix.length - 1;
		if (max < 0 || matrix[0].length == 0) {
			return false;
		}
		while (min <= max) {
			final int mid = (max + min) / 2;
			if (matrix[mid][0] <= target
					&& matrix[mid][matrix[0].length - 1] >= target) {
				int cmin = 0, cmax = matrix[0].length - 1;
				while (cmin <= cmax) {
					final int cmid = (cmin + cmax) / 2;
					if (matrix[mid][cmid] == target) {
						return true;
					} else if (matrix[mid][cmid] < target) {
						cmin = cmid + 1;
					} else {
						cmax = cmid - 1;
					}
				}
				return false;
			} else if (matrix[mid][0] > target) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		return false;
	}
}
