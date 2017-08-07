package code.two;

//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
//For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
//the contiguous subarray [4,-1,2,1] has the largest sum = 6.
//
//click to show more practice.
public class MaxSubArray_time {

	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int curNum = 0;
		for (int i = 0; i < nums.length; i++) {
			curNum += nums[i];
			if (curNum > max) {
				max = Math.max(max, curNum);
			}

			if (curNum < 0) {
				curNum = 0;
			}
		}

		return max;
	}


	public int maxSubArray1(int[] nums) {

		int max = nums[0];
		for (int i = 1; i < nums.length+1; i++) {
			int a = max(nums, i);
			max = max > a ? max : a;
		}
		return max;

    }

	private int max(int[] nums, int i) {
		int max = nums[0];
		for (int j = 0; j < nums.length + 1 - i; j++) {
			int a = 0;
			for (int j2 = 0; j2 < i; j2++) {
				a += nums[j + j2];
			}
			max = max > a ? max : a;
		}
		return max;
	}
}
