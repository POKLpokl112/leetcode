package code.one;

public class LengthOfLongestSubstring_NO {
	public static int lengthOfLongestSubstring(String s) {
		int x = 0;
		for (int i = 0; i < s.length(); i++) {
			int k = i + 1;

			boolean b = true;
			while (k < s.length() && b) {
				char ck = s.charAt(k);
				for (int j = i; j < k; j++) {
					if (s.charAt(j) == ck) {
						b = false;
						k--;
						break;
					}
				}
				k++;
			}
			x = k - i > x ? k - i : x;
		}

		return x;
    }
}
