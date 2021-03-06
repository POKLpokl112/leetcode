package code.two;

//Implement int sqrt(int x).
//
//Compute and return the square root of x.
//
//x is guaranteed to be a non-negative integer.
//
//
//Example 1:
//
//Input: 4
//Output: 2
//Example 2:
//
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
public class MySqrt {
	public int mySqrt(final int x) {

		int left = 1,right = x;

		while (right > left) {
			final int mid = left + (right - left) / 2;

			if (mid > x / mid) {
				right = mid;
			} else {
				if (mid + 1 > x / (mid + 1)) {
					return mid;
				}
				left = mid;
			}
		}

		return x;

	}

	public static void main(final String[] args) {
		new MySqrt().mySqrt(4);
	}
}
