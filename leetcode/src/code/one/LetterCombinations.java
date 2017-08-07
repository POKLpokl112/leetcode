package code.one;

import java.util.ArrayList;
import java.util.List;

class LetterCombinations {
	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.equals("")) {
			return new ArrayList<>();
		}
		List<String> list = new ArrayList<>();
		list.add("");
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		for (int i = 0; i < digits.length(); i++) {
			int j = digits.charAt(i) - 48;
			String str = mapping[j];
			List<String> array = new ArrayList<>();
			for (String s : list) {
				for (int k = 0; k < str.length(); k++) {
					array.add(s + str.charAt(k));
				}
			}
			list = array;
		}
		return list;
	}


}
