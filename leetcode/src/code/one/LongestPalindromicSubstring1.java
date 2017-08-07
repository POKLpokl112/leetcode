package code.one;

public class LongestPalindromicSubstring1 {

	public String longestPalindrome(String s) {

		for (int i = s.length(); i > 0; i--) {
			for (int j = 0; j < s.length() - i + 1; j++) {
				String q = s.substring(j, j + i);
				boolean b = true;

				int length = (q.length() + 1) / 2;
				for (int k = 0; k < length; k++) {
					if (q.charAt(k) != q.charAt(q.length() - k - 1)) {
						b = false;
						break;
					}
				}

				if (b) {
					return q;
				}
			}
		}

		return null;
	}

}
