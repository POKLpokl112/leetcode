package code.one;

public class MyAtoi {
	public int myAtoi(String str) {
		int q = 0;
		int x = 1;

		int t = 0;
		int i = 0;
		while (i < str.length()) {
			char c = str.charAt(i);
			i++;
			if (c == ' ') {
				if (t != 0) {
					return q * x;
				}
				continue;
			}
			else if (c <= '9' && c >= '0') {
				int w = q;
				q = q * 10;
				q += c - 48;
				if (q / 10 != w) {
					if (x == 1) {
						return Integer.MAX_VALUE;
					}
					return Integer.MIN_VALUE;
				}
				t = 2;
			} else if (c == '-') {
				if (t != 0) {
					return q * x;
				}
				x = -1;
				t = 1;

			} else if (c == '+') {
				if (t != 0) {
					return q * x;
				}
				t = 1;
			} else {
				return q * x;
			}
		}
		return q * x;
	}

	public static void main(String[] args) {
		System.out.println(new MyAtoi().myAtoi(" b11228552307"));
	}
}