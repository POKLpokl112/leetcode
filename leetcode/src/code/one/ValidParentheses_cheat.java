package code.one;

import java.util.Stack;

public class ValidParentheses_cheat {

	public boolean validParentheses(String s) {
		Stack<Character> ss = new Stack<>();
		for (char c : s.toCharArray()) {
			if(c=='{')
				ss.push('}');
			else if(c=='(')
				ss.push(')');
			else if(c=='[')
				ss.push(']');
			else{
				if(ss.isEmpty()||c!=ss.pop()){
					return false;
				}
			}
		}
		return ss.isEmpty();
	}
}
