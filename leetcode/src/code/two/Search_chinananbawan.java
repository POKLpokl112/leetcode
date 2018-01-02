package code.two;

//Follow up for "Search in Rotated Sorted Array":
//What if duplicates are allowed?
//
//Would this affect the run-time complexity? How and why?
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Write a function to determine if a given target is in the array.
//
//The array may contain duplicates.

public class Search_chinananbawan {
	public boolean search(final int[] nums, final int target) {
		if (nums.length == 0) {
			return false;
		}

		int max = nums.length - 1, min = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				if (target > nums[i] || target < nums[i + 1]) {
					return false;
				}
				max = i;
				min = i + 1;
				break;
			}
		}

		int a, b;
		if (target >= nums[0]) {
			a = 0;
			b = max;
		} else {
			a = min;
			b = nums.length - 1;
		}

		while (b >= a) {
			final int m = (a + b) / 2;

			if (nums[m] == target) {
				return true;
			} else if (nums[m] > target) {
				b = m - 1;
			} else {
				a = m + 1;
			}
		}
		return false;

	}
}
