package code.two;

import java.util.Stack;

//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100".
//

public class AddBinary_imslow {

	// fast way is :array instead of stact follow long length of two string
	public String addBinary(final String a, final String b) {
		final Stack<Character> s = new Stack<>();

		final int length = a.length() > b.length() ? a.length() : b.length();
		int r = 0;
		for (int i = 0; i < length; i++) {
			final int ac = i > a.length() - 1
					? 0
					: a.charAt(a.length() - 1 - i) == '1' ? 1 : 0;
			final int bc = i > b.length() - 1
					? 0
					: b.charAt(b.length() - 1 - i) == '1' ? 1 : 0;

			final int sum = r + ac + bc;
			if (sum == 3) {
				s.push('1');
				r = 1;
			} else if (sum == 2) {
				s.push('0');
				r = 1;
			} else if (sum == 1) {
				s.push('1');
				r = 0;
			} else {
				s.push('0');
				r = 0;
			}

		}

		if (r == 1) {
			s.push('1');
		}

		final StringBuffer sb = new StringBuffer();
		while (!s.empty()) {
			sb.append(s.pop());
		}

		return sb.toString();
	}

	public String asd(final String a, final String b) {
		int la = a.length();
		int lb = b.length();
		final int length = la > lb ? la : lb;

		final int[] ii = new int[length + 1];

		for (int i = length; i > 0; i--) {
			final int ia = la < 1 ? 0 : a.charAt(--la) == '1' ? 1 : 0;
			final int ib = lb < 1 ? 0 : b.charAt(--lb) == '1' ? 1 : 0;

			final int sum = ia + ib + ii[i];
			if (sum > 1) {
				ii[i - 1] = 1;
				ii[i] = sum % 2;
			} else {
				ii[i] = sum;
			}

		}

		final StringBuffer sb = new StringBuffer();
		for (int i = ii[0] > 0 ? 0 : 1; i < ii.length; i++) {
			sb.append(ii[i]);
		}
		return sb.toString();
	}

}
