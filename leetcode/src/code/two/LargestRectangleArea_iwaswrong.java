package code.two;

import java.util.Stack;

//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//For example,
//Given heights = [2,1,5,6,2,3],
//return 10.
public class LargestRectangleArea_iwaswrong {
	public int largestRectangleArea(final int[] heights) {
		asd
		if (heights.length == 1) {
			return heights[0];
		}
		int right = heights.length / 2, left = right - 1, size = 0, min = 0;
		while (left > -1 && right < heights.length) {
			if (heights[left] > heights[right]) {
				min = heights[right];
				final int a = (right - left + 1) * min;
				size = size > a ? size : a;
				left--;
			} else {
				min = heights[left];
				final int a = (right - left + 1) * min;
				size = size > a ? size : a;
				right++;
			}
		}

		return size;
	}

	public int a(final int[] height) {
		final int len = height.length;
		final Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			final int h = (i == len ? 0 : height[i]);
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				final int tp = s.pop();
				maxArea = Math.max(maxArea,
						height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;
	}

}

// For explanation, please see
// http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
//
// public class Solution {
// public int largestRectangleArea(int[] height) {
// int len = height.length;
// Stack<Integer> s = new Stack<Integer>();
// int maxArea = 0;
// for(int i = 0; i <= len; i++){
// int h = (i == len ? 0 : height[i]);
// if(s.isEmpty() || h >= height[s.peek()]){
// s.push(i);
// }else{
// int tp = s.pop();
// maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 -
// s.peek()));
// i--;
// }
// }
// return maxArea;
// }
// }
// OP’s Note: Two years later I need to interview again. I came to this problem
// and I couldn’t understand this solution. After reading the explanation
// through the link above, I finally figured this out again.
// Two key points that I found helpful while understanding the solution:
//
// Do push all heights including 0 height.
// i - 1 - s.peek() uses the starting index where height[s.peek() + 1] >=
// height[tp], because the index on top of the stack right now is the first
// index left of tp with height smaller than tp’s height.
