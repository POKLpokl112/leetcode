package code.one;

//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//For example, 
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
public class Trap_cheat {
	public int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int max = 0;
		while (left <= right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);

			if (leftMax < rightMax) {
				max += leftMax - height[left];
				left++;
			} else {
				max += rightMax - height[right];
				right--;
			}
		}
		return max;

	}
}
