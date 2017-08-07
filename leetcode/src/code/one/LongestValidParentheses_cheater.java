package code.one;

import java.util.Stack;

public class LongestValidParentheses_cheater {
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		int i = 0;
		int max = 0;
		for (char c : s.toCharArray()) {
			i++;
			if (c == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					j = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						max = max > i - j ? max : i - j;
					} else {
						max = max > i - stack.peek() ? max : i - stack.peek();
					}
				}
			}
		}
		return max;
    }
}
