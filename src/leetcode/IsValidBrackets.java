package leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * 
 * @author stick
 *
 */
public class IsValidBrackets {

	public boolean isValid(String s) {
		Stack<Character> st = new Stack<Character>();
		char[] ca = s.toCharArray();
		for (char c : ca) {
			if ('{' == c || '[' == c || '(' == c) {
				st.push(c);
			} else if ('}' == c) {
				if (st.empty() || !st.peek().equals('{')) {
					return false;
				} else {
					st.pop();
				}
			} else if (']' == c) {
				if (st.empty() || !st.peek().equals('[')) {
					return false;
				} else {
					st.pop();
				}
			} else if (')' == c) {
				if (st.empty() || !st.peek().equals('(')) {
					return false;
				} else {
					st.pop();
				}
			}
		}
		if (st.empty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		IsValidBrackets test = new IsValidBrackets();
		System.out.println(test.isValid("]"));
	}
}
