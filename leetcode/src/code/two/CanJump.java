package code.two;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.
public class CanJump {

	 public boolean canJump(int[] nums) {
		int length = nums.length - 1;
		int i = 0;
		while (i < length && nums[i] + i < length) {
			int k = i;
			for (int j = k + 1; j < k + nums[k] + 1; j++) {
				if (j + nums[j] > nums[i] + i) {
					i = j;
				}
			}
			if (k == i) {
				return false;
			}
		}

		return true;
	 }

	// int lastPos = nums.length - 1;
	// for (int i = nums.length - 1; i >= 0; i--) {
	// if (i + nums[i] >= lastPos) {
	// lastPos = i;
	// }
	// }
	// return lastPos == 0;
}
