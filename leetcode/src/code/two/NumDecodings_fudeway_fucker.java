package code.two;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.
public class NumDecodings_fudeway_fucker {
	public int numDecodings(final String s) {
		if (s.length() == 0) {
			return 0;
		}

		final char[] c = s.toCharArray();
		final int[] ii = new int[c.length + 1];
		ii[0] = 1;
		if (c[0] != '0') {
			ii[1] = 1;
		}

		for (int i = 1; i < c.length; i++) {
			if (c[i] == '0') {
				if (c[i - 1] == '0' || c[i - 1] > '2') {
					return 0;
				}
			}
			if (c[i - 1] == '1' || (c[i - 1] == '2' && c[i] < '7')) {
				if (c[i] == '0') {
					ii[i + 1] = ii[i];
					continue;
				}
				ii[i + 1] = ii[i - 1] + ii[i];
			} else {
				ii[i + 1] = ii[i];
			}
		}
		if (c[c.length - 1] == '0') {

			return c.length == 1
					? 0
					: c[c.length - 2] == '0' || c[c.length - 2] > '2'
							? 0
							: ii[ii.length - 3];
		}

		return ii[ii.length - 1];
	}

}

// int n = s.length();
// if (n == 0) return 0;
//
// int[] memo = new int[n+1];
// memo[n] = 1;
// memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
//
// for (int i = n - 2; i >= 0; i--)
// if (s.charAt(i) == '0') continue;
// else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ?
// memo[i+1]+memo[i+2] : memo[i+1];
//
// return memo[0];
