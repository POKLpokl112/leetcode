package code.two;

//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non-space characters only.
//
//For example, 
//Given s = "Hello World",
//return 5.
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int j = 0;
		boolean b = true;
		for (int i = s.length() - 1; i > -1; i--) {
			if (b) {
				if (s.charAt(i) != ' ') {
					j++;
					b = false;
				}
			} else {
				if (s.charAt(i) == ' ') {
					break;
				}
				j++;
			}
		}

		return j;
	}
}
