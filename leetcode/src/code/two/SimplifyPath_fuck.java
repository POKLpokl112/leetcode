package code.two;

import java.util.Stack;

//Given an absolute path for a file (Unix-style), simplify it.
//
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
//click to show corner cases.

public class SimplifyPath_fuck {

	public String simplifyPath(final String path) {
		final Stack<Character> s = new Stack<>();
		if (path.charAt(path.length() - 1) != '/') {
			s.push(path.charAt(path.length() - 1));
		}
		for (int i = path.length() - 2; i > -1; i--) {

			if (path.charAt(i) == '/') {
				break;
			} else {
				s.push(path.charAt(i));
			}
		}

		final char[] c = new char[s.size() + 1];
		c[0] = '/';
		for (int i = 1; i < c.length; i++) {
			c[i] = s.pop();
		}

		return new String(c);

	}
}
