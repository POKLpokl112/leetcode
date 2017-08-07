package code.one;

import java.util.Arrays;

public class FirstMissingPositive_slower {
	// the faster answer is find smallest one by one
	public int firstMissingPositive(int[] nums) {
		Arrays.sort(nums);

		int j = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == j) {
				j++;
			} else if (nums[i] > j) {
					return j;
			}
		}
		return j;
    }
}
