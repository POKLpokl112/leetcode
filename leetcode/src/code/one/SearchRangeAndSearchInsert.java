package code.one;

//Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].
public class SearchRangeAndSearchInsert {
	public int[] searchRange(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;
		int i = -1;
		while (end >= start) {
			int middle = (start + end) / 2;
			if (nums[middle] > target) {
				end = middle - 1;
			} else if (nums[middle] < target) {
				start = middle + 1;
			} else {
				i = middle;
				break;
			}
		}

		if (i == -1) {
			int[] ii = {-1, -1};
			return ii;
		} else {
			int j = i;
			int k = i;
			while (--j > -1) {
				if (nums[j] != target) {
					break;
				}
			}

			while (++k < nums.length) {
				if (nums[k] != target) {
					break;
				}
			}
			int[] iii = {++j, --k};
			return iii;
		}

	}
	
	 public int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (end >= start) {
			int middle = (start + end) / 2;
			if (nums[middle] > target) {
				end = middle - 1;
			} else if (nums[middle] < target) {
				start = middle + 1;
			} else {
				return middle;
			}
		}

		return start;
	 }

}
