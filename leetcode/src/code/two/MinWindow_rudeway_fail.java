package code.two;

//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//For example,
//S = "ADOBECODEBANC"
//T = "ABC"
//Minimum window is "BANC".
//
//Note:
//If there is no such window in S that covers all characters in T, return the empty string "".
//
//If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class MinWindow_rudeway_fail {
	public String minWindow(final String s, final String t) {
		final char[] sc = s.toCharArray();
		final char[] tc = t.toCharArray();
		int min = s.indexOf(tc[0]), max = s.lastIndexOf(tc[0]);
		if (min == -1) {
			return "";
		}

		for (int i = 1; i < tc.length; i++) {
			final int smin = s.indexOf(tc[i]), smax = s.lastIndexOf(tc[i]);
			if (smin == -1) {
				return "";
			}

			if (min != 0 && min > smin) {
				min = smin;
			}

			if (max != s.length() - 1 && max < smax) {
				max = smax;
			}

			if (min == 0 && max != s.length() - 1) {
				break;
			}
		}

		while (qwe(sc, sc[min], min + 1, max + 1)) {
			min++;
			if (t.indexOf(s.charAt(min)) == -1) {
				while (true) {
					min++;
					if (t.indexOf(s.charAt(min)) > 0) {
						break;
					}
				}
			}
		}

		while (qwe(sc, sc[max], min, max - 1)) {
			max--;
			if (t.indexOf(s.charAt(max)) == -1) {
				while (true) {
					max--;
					if (t.indexOf(s.charAt(max)) > 0) {
						break;
					}
				}
			}
		}

		return s.substring(min, max + 1);

	}

	boolean qwe(final char[] cc, final char c, final int from, final int to) {
		for (int i = from; i < to; i++) {
			if (cc[i] == c) {
				return true;
			}
		}
		return false;
	}

}

// def minWindow(self, s, t):
// need, missing = collections.Counter(t), len(t)
// i = I = J = 0
// for j, c in enumerate(s, 1):
// missing -= need[c] > 0
// need[c] -= 1
// if not missing:
// while i < j and need[s[i]] < 0:
// need[s[i]] += 1
// i += 1
// if not J or j - i <= J - I:
// I, J = i, j
// return s[I:J]

// int lengthOfLongestSubstring(string s) {
// vector<int> map(128,0);
// int counter=0, begin=0, end=0, d=0;
// while(end<s.size()){
// if(map[s[end++]]++>0) counter++;
// while(counter>0) if(map[s[begin++]]-->1) counter--;
// d=max(d, end-begin); //while valid, update d
// }
// return d;
// }
