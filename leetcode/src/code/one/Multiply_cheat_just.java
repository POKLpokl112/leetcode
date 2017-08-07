package code.one;

public class Multiply_cheat_just {
	 public String multiply(String num1, String num2) {

		int m = num1.length() - 1;
		int n = num2.length() - 1;

		int[] pos = new int[m + n + 2];
		for (int i = m; i >= 0; i--) {
			for (int j = n; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + pos[p2];

				pos[p1] += sum / 10;
				pos[p2] = (sum) % 10;
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i : pos) {
			if (sb.length() != 0 || i != 0) {
				sb.append(i);
			}
		}
		return sb.length() == 0 ? "0" : sb.toString();

	 }

	public static void main(String[] args) {
		new Multiply_cheat_just().multiply("1", "1");
	}

}
