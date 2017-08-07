package code.one;

public class Jump {
	public int jump(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}

		int j = 0, a = 0;
		while (j + nums[j] < nums.length - 1) {
			a++;
			j = asd(nums, j);
		}

		if (j < nums.length - 1) {
			a++;
		}

		return a;

    }

	private int asd(int[] nums, int i2) {
		int length = i2 + nums[i2] + 1 > nums.length
				? nums.length
				: i2 + nums[i2] + 1;
		int j = i2;
		int max = 0;
		for (int i = i2 + 1; i < length; i++) {
			if (nums[i] + i > max) {
				max = nums[i] + i;
				j = i;
			}
		}
		return j;
	}
}
