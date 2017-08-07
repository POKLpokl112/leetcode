package code.one;

public class StrStr {
	public int strStr(String haystack, String needle) {
		int i = 0;
		int length = needle.length();
		while (i + length <= haystack.length()) {
			boolean b = true;
			for (int j = i; j < i + length; j++) {
				if (haystack.charAt(j) != needle.charAt(j - i)) {
					b = false;
					break;
				}
			}
			if (b) {
				return i;
			}
			i++;
		}

		return -1;
    }

	public static void main(String[] args) {
	}
}
