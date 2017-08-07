package code.one;

public class Reverse_Integer {
	public int reverse(int x) {
		boolean b = true;
		long p = (long) x;
		if (x < 0) {
			p = p * -1;
			b = false;
		}
		long a = p;
		int c = 0;
		while (a >= 10) {
			c++;
			a = a / 10;
		}

		long y = 0;
		int j = 1;
		while (c >= 0) {
			long m = (long) Math.pow(10, j);
			long n = (long) Math.pow(10, c);
			y = y + (p % m) / (m / 10) * n;
			j++;
			c--;

		}

		if (b ? y > Integer.MAX_VALUE : y * -1 < Integer.MIN_VALUE) {
			return 0;
	}
		int k = (int) y;
		return b ? k : k * -1;
	}

}
