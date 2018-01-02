package code.two;

import java.util.ArrayList;
import java.util.List;

//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//For example:
//Given "25525511135",
//
//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
public class RestoreIpAddresses_GaussianDistribution_normal {
	public List<String> restoreIpAddresses(final String s) {
		final List<String> list = new ArrayList<>();
		dododo(list, null, 0, 0, s);
		return list;
	}

	private void dododo(final List<String> list, final String ss, final int i,
			final int j, final String s) {

		if (j >= s.length()) {
			return;
		}

		if (s.charAt(j) == '0') {
			if (i == 3) {
				if (j + 1 < s.length()) {
					return;
				} else if (j + 1 == s.length()) {
					final String sss = (ss == null ? "" : ss + ".")
							+ s.substring(j, j + 1);
					list.add(sss);
					return;
				}
			}

			final String sss = (ss == null ? "" : ss + ".")
					+ s.substring(j, j + 1);
			dododo(list, sss, i + 1, j + 1, s);
			return;
		}

		if (i == 3) {
			if (s.length() - j > 3) {
				return;
			}

			final String sss = s.substring(j);
			if (!ccc(sss)) {
				return;
			}

			list.add(ss + "." + sss);
			return;
		}

		for (int k = 1; k < 3; k++) {
			if (j + k > s.length()) {
				return;
			}
			if (ccc(s.substring(j, j + k))) {
				final String sss = (ss == null ? "" : ss + ".")
						+ s.substring(j, j + k);
				dododo(list, sss, i + 1, j + k, s);
			}

		}

		if (j + 3 > s.length()) {
			return;
		}

		if (ccc(s.substring(j, j + 3))) {
			final String sss = (ss == null ? "" : ss + ".")
					+ s.substring(j, j + 3);
			dododo(list, sss, i + 1, j + 3, s);
		}

	}

	private boolean ccc(final String s2) {
		if (s2.length() < 3) {
			return true;
		} else if (s2.length() > 3) {
			return false;
		} else {
			if (s2.charAt(0) > '2'
					|| (s2.charAt(0) == '2' && s2.charAt(1) > '5')
					|| (s2.charAt(0) == '2' && s2.charAt(1) == '5'
							&& s2.charAt(2) > '5')) {
				return false;
			}

			return true;
		}

	}
}
