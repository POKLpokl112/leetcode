package code.one;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        
		int y = 0;
		int j = x;

		while (j > 0) {
			int k = j % 10;
			int t = y;
			y = 10 * y + k;
			if ((y - k) / 10 != t) {
				return false;
			}
			j = j / 10;
		}

		return y == x;

    }
}
