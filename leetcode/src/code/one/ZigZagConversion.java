package code.one;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		int asd = 2 * numRows - 2;
		int a = s.length() % asd;
		int num = a == 0 ? 2 * s.length() / asd : a > numRows ? 2 * s.length() / asd + 2 : 2 * s.length() / asd + 1;
		char[][] qwe = new char[numRows][num];
		for (int i = 0; i < num; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < numRows; j++) {
					if ((i / 2) * asd + j > s.length() - 1) {
						break;
					}
					qwe[j][i] = s.charAt((i / 2) * asd + j);
				}
			} else {
				for (int j = numRows - 2; j > 0; j--) {
					if ((i / 2) * asd + 2 * numRows - 2 - j > s.length() - 1) {
						break;
					}
					qwe[j][i] = s.charAt((i / 2) * asd + 2 * numRows - 2 - j);
			}
		}
		}

		char[] c = new char[s.length()];
		int i = 0;
		for (int j = 0; j < qwe.length; j++) {
			for (int j2 = 0; j2 < qwe[j].length; j2++) {
				if (qwe[j][j2] != 0) {
					c[i] = qwe[j][j2];
					i++;
			}
			}

		}
		return String.copyValueOf(c);
	}

	public static void main(String[] args) {
		char[] i = new char[10];
		System.out.println(i[0] == 0);
	}
}
