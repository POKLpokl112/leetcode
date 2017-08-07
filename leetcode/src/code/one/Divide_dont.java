package code.one;

public class Divide_dont {
	public int divide(int d, int c) {
		if (c == 0 || (d == Integer.MIN_VALUE && c == -1))
			return Integer.MAX_VALUE;
		return divide((long) d, (long) c);
	        
     }

	public int divide(long a, long b) {
		boolean neg = (a > 0) == (b > 0);
		if (a < 0)
			a = -a;
		if (b < 0)
			b = -b;
		if (a < b)
			return 0;
		int msb = 0;
		for (msb = 0; msb < 32; msb++) {
			if ((b << msb) >= a)
				break;
		}
		int q = 0;
		for (int i = msb; i >= 0; i--) {
			if ((b << i) > a)
				continue;
			q |= (1 << i);
			a -= (b << i);
		}

		return neg ? q : -q;
	}

	public static void main(String[] args) {
		new Divide_dont().divide(-2147483648, 1);
	}
}
