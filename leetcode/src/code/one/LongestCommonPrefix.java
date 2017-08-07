package code.one;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() == 0) {
				return "";
			}

		}
		StringBuffer s = new StringBuffer();
		int j = 0;
		boolean b = true;
		while (b) {
			for (int i = 0; i < strs.length; i++) {

				if (j == strs[i].length() - 1) {
					b = false;
				}

				if (strs[0].charAt(j) != strs[i].charAt(j)) {
					b = false;
					j = -1;
					break;
				}
			}
			if (j >= 0) {
				s.append(strs[0].charAt(j));
			}
			j++;
		}
		return s.toString();
    }

	public static void main(String[] args) {
		String[] s = { "aa", "aa" };
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(s));
	}
}
