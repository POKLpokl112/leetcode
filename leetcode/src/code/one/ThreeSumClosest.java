package code.one;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);

		int result = nums[0] + nums[1] + nums[nums.length - 1];

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
				int lo = i + 1, hi = nums.length - 1;
				while (lo < hi) {
					int eee = nums[i] + nums[lo] + nums[hi];
					if (eee > target)
						hi--;
					else
						lo++;
					if (Math.abs(target - eee) < Math.abs(target - result)) {
						result = eee;
					}
			}
		}

		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 13, 2, 0, -14, -20, 19, 8, -5, -13, -3, 20, 15, 20, 5, 13, 14, -17, -7, 12, -6, 0, 20, -19, -1,
				-15, -2, 8, -2, -9, 13, 0, -3, -18, -9, -9, -19, 17, -14, -19, -4, -16, 2, 0, 9, 5, -7, -4, 20, 18, 9,
				0, 12, -1, 10, -17, -11, 16, -13, -14, -3, 0, 2, -18, 2, 8, 20, -15, 3, -13, -12, -2, -19, 11, 11, -10,
				1, 1, -10, -2, 12, 0, 17, -19, -7, 8, -19, -17, 5, -5, -10, 8, 0, -12, 4, 19, 2, 0, 12, 14, -9, 15, 7,
				0, -16, -5, 16, -12, 0, 2, -16, 14, 18, 12, 13, 5, 0, 5, 6 };
		System.out.println(new ThreeSumClosest().threeSumClosest(nums, -59));
	}
}
