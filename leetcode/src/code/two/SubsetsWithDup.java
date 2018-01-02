package code.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
//Note: The solution set must not contain duplicate subsets.
//
//For example,
//If nums = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]

public class SubsetsWithDup {
	public List<List<Integer>> subsetsWithDup(final int[] nums) {
		Arrays.sort(nums);
		final List<List<Integer>> list = new ArrayList<>();
		gogogo(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void gogogo(final List<List<Integer>> list,
			final List<Integer> array, final int[] nums, final int i) {
		list.add(array);
		for (int j = i; j < nums.length; j++) {

			int k = 1;
			while (j + k < nums.length && nums[j] == nums[j + k]) {
				k++;
			}

			if (k != 1) {
				for (int k2 = 0; k2 < k; k2++) {
					final List<Integer> arr = new ArrayList<>(array);
					for (int l = 0; l < k2; l++) {
						arr.add(nums[j]);
					}
					gogogo(list, arr, nums, j + k);
				}
				j += k - 1;
			} else {
				final List<Integer> arr = new ArrayList<>(array);
				arr.add(nums[j]);
				gogogo(list, arr, nums, j + 1);
			}

		}
	}
}
