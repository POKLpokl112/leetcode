package code.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array S of n integers, are there elements a, b, c, 
//and d in S such that a + b + c + d = target? 
//Find all unique quadruplets in the array which gives the sum of target.
//
//Note: The solution set must not contain duplicate quadruplets.
class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return asd(nums, 0, 4, target);
	}

	private List<List<Integer>> asd(int[] nums, int start, int k, int target) {

		List<List<Integer>> list = new ArrayList<>();
		if (k == 2) {
			int lo = start, hi = nums.length - 1;
			while (lo < hi) {
				int sum = nums[lo] + nums[hi];
				if (sum == target) {
					List<Integer> l = new ArrayList<>();
					l.add(nums[lo]);
					l.add(nums[hi]);
					list.add(l);
					while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
					while (lo < hi && nums[hi] == nums[hi - 1])
						hi--;
					hi--;
					lo++;
				} else if (sum > target) {
					hi--;
				} else {
					lo++;
				}
			}

			return list;
		} else {

			for (int i = start; i < nums.length - k + 1; i++) {
				if (i > start && nums[i] == nums[i - 1])
					continue;
				List<List<Integer>> array = asd(nums, i + 1, k - 1, target - nums[i]);
				for (List<Integer> l : array) {
					l.add(0, nums[i]);
				}
				list.addAll(array);
			}
			return list;
		}
	}
}
