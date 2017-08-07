package code.one;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_cheat {
	 public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		s(list, 0, 0, "", n);
		return list;
	}

	public void s(List<String> list, int left, int right, String s, int max) {
		if (s.length() == max * 2) {
			list.add(s);
			return;
		}

		if (left < max) {
			s(list, left + 1, right, s + "(", max);
		}

		if (right < left) {
			s(list, left, right + 1, s + ")", max);
		}
	}

}
