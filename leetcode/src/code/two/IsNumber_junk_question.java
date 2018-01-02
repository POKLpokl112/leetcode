package code.two;

//Validate if a given string is numeric.
//
//Some examples:
//"0" => true
//" 0.1 " => true
//"abc" => false
//"1 a" => false
//"2e10" => true
//Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
//
//Update (2015-02-10):
//The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
public class IsNumber_junk_question {
	public boolean isNumber(String s) {
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}

		final char w = s.charAt(0);
		if (w > '9' || w < '0') {
			return false;
		}

		for (int i = 1; i < s.length(); i++) {
			final char q = s.charAt(i);
			if (q == '.') {
				final char e = s.charAt(i - 1);
				if (e <= '9' && e >= '0') {
					continue;
				}
			}
			if ((q > '9' || q < '0') && q != 'e') {
				return false;
			}
		}

		return true;

	}

	public static void main(final String[] args) {
		System.out.println(new IsNumber_junk_question().isNumber("11"));
	}
}
