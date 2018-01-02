package code.two;

//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//For example,
//Given:
//s1 = "aabcc",
//s2 = "dbbca",
//
//When s3 = "aadbbcbcac", return true.
//When s3 = "aadbbbaccc", return false.
public class IsInterleave_im_fucking_stupid {
	public boolean isInterleave(final String s1, final String s2,
			final String s3) {

		if (s3.length() != (s1.length() + s2.length())) {
			return false;
		}

		final char[] c1 = s1.toCharArray();
		final char[] c2 = s2.toCharArray();
		final char[] c3 = s3.toCharArray();

		final boolean[][] cc = new boolean[c1.length + 1][c2.length + 1];

		return qwe(c1, c2, c3, 0, 0, 0, cc);

		// for (int i = 0; i < c1.length + 1; i++) {
		// for (int j = 0; j < c2.length + 1; j++) {
		// if (i == 0 && j == 0) {
		// cc[i][j] = true;
		// } else if (i == 0) {
		// cc[i][j] = cc[i][j - 1] && c3[j - 1] == c2[j - 1];
		// } else if (j == 0) {
		// cc[i][j] = cc[i - 1][j] && c3[i - 1] == c1[i - 1];
		// } else {
		// cc[i][j] = (cc[i][j - 1] && c3[i + j - 1] == c2[j - 1])
		// || (cc[i - 1][j] && c3[i + j - 1] == c1[i - 1]);
		// }
		// }
		// }
		//
		// return cc[c1.length][c2.length];
	}

	private boolean qwe(final char[] c1, final char[] c2, final char[] c3,
			final int i, final int j, final int k, final boolean[][] cc) {
		if (cc[i][j]) {
			return false;
		}

		if (k == c3.length) {
			return true;
		}

		cc[i][j] = !((i < c1.length && c1[i] == c3[k]
				&& qwe(c1, c2, c3, i + 1, j, k + 1, cc))
				|| (j < c2.length && c2[j] == c3[k]
						&& qwe(c1, c2, c3, i, j + 1, k + 1, cc)));

		return !cc[i][j];
	}

	public static void main(final String[] args) {
		new IsInterleave_im_fucking_stupid().isInterleave("a", "b", "ab");
	}
}
