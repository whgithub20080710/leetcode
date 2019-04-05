package leetcode;

/**
 * 32. 最长有效括号 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()" 输出: 2 解释: 最长有效括号子串为 "()"
 * 
 * @author stick
 *
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s.length() <= 1) {
			return 0;
		}
		// 顺序的找弹栈出现问题的串term，记录该串的最大匹配
		int index = 0;
		int maxMatch = 0;
		while (index < s.length()) {
			int leftCount = 0; // 栈剩余量
			int matchCount = 0;// 当前term最大匹配数量

			int[] mapCount = new int[s.length() + 1]; // 当前term，不同【未匹配数量left
														// count】作为【起始】的已匹配数量
			while (leftCount >= 0 && index < s.length()) {
				if (s.charAt(index) == '(') {
					leftCount++;
				} else {
					if (leftCount > 0) {
						mapCount[leftCount] = mapCount[leftCount] + 1;// 记录当前term，不同【未匹配数量left
																		// count】作为【起始】的已匹配数量
						if (mapCount[leftCount + 1] != 0) { // 合并【高的起始】的已匹配数量，由于
															// leftCount 走到这里必然
															// <
															// s.length，所以不必检查下标
							mapCount[leftCount] += mapCount[leftCount + 1];
							mapCount[leftCount + 1] = 0;
						}
						leftCount--;
					} else {
						leftCount--;
					}
				}
				index++;
			}
			for (int i = 0; i < s.length(); i++) {
				if (mapCount[i] > matchCount) {
					matchCount = mapCount[i];
				}
			}
			if (maxMatch < matchCount) {
				maxMatch = matchCount;
			}
		}
		return maxMatch * 2;
	}

	public static void main(String[] args) {
		LongestValidParentheses test = new LongestValidParentheses();
		System.out.println(test.longestValidParentheses(")()())("));
	}
}
