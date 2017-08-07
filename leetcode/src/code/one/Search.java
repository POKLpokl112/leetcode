package code.one;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
public class Search {
	 public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}

		int end = nums.length - 1;
		int start = 0;
		while (end >= start && nums[end] < nums[start]) {
				if (nums[0] > target) {
					start++;
					continue;
				}
				end--;
				continue;
		}
		
		while (end >= start) {
			int middle = (start + end) / 2;
			if (nums[middle] > target) {
				end = middle - 1;
			} else if (nums[middle] < target) {
				start = middle + 1;
			} else
				return middle;
		}

		return -1;
	 }
}
