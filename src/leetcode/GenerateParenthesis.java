package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author stick
 *
 */
public class GenerateParenthesis {

	// 暴力法
	public List<String> generateParenthesis1(int n) {
		List<String> combinations = new ArrayList();
		generateAll(new char[2 * n], 0, combinations);
		return combinations;
	}

	public void generateAll(char[] current, int pos, List<String> result) {
		// System.out.print("1");
		if (pos == current.length) {
			if (valid(current))
				result.add(new String(current));
		} else {
			current[pos] = '(';
			generateAll(current, pos + 1, result);
			current[pos] = ')';
			generateAll(current, pos + 1, result);
		}
	}

	public boolean valid(char[] current) {
		int balance = 0;
		for (char c : current) {
			if (c == '(')
				balance++;
			else
				balance--;
			if (balance < 0)
				return false;
		}
		return (balance == 0);
	}

	// 回溯法
	public List<String> generateParenthesis2(int n) {
		List<String> ans = new ArrayList();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}

	public void backtrack(List<String> ans, String cur, int open, int close, int max) {
		// System.out.print("1");
		if (cur.length() == max * 2) {
			ans.add(cur);
			return;
		}

		if (open < max)
			backtrack(ans, cur + "(", open + 1, close, max);
		if (close < open)
			backtrack(ans, cur + ")", open, close + 1, max);
	}

	// 闭合数
	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList();
		if (n == 0) {
			ans.add("");
		} else {
			for (int c = 0; c < n; ++c)
				for (String left : generateParenthesis(c))
					for (String right : generateParenthesis(n - 1 - c)) {
						// System.out.print(1);
						ans.add("(" + left + ")" + right);
					}
		}
		return ans;
	}

	public static void main(String[] args) {
		GenerateParenthesis test = new GenerateParenthesis();
		System.out.println(test.generateParenthesis(3).toString());
	}
}
