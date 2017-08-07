package code.one;

public class MaxArea {
    public int maxArea(int[] height) {
		int m = 0;
		int l = 0;
		int r = height.length - 1;
		while (l < r) {
			int i = height[l];
			int y = height[r];
			int k = i < y ? i : y;
			m = m > k * (r - l) ? m : k * (r - l);
			if (i < y) {
				l++;
			} else {
				r--;
			}
		}
		return m;
    }
}
