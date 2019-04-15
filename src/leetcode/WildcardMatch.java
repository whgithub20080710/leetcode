package leetcode;

/**
 * 44. 通配符匹配
 *  给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 * 
 * '?' 可以匹配任何单个字符。 '*' 可以匹配任意字符串（包括空字符串）。 * 
 * @author stick
 *
 */
public class WildcardMatch {

	public boolean isMatch(String s, String p) {
		int sl = s.length(), pl = p.length();
		boolean[][] m = new boolean[sl + 1][pl + 1];
		m[0][0] = true;
		for (int i = 0; i <= sl; i++) {
			for (int j = 1; j <= pl; j++) {
				if (p.charAt(j - 1) == '*') {
					m[i][j] = m[i][j - 1] || (i > 0 && m[i - 1][j]);
				} else {
					m[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
							&& m[i - 1][j - 1];
				}
			}
		}
		return m[sl][pl];
	}

	public static void main(String[] args) {
		WildcardMatch test = new WildcardMatch();
		System.out.println(test.isMatch("adceb", "*a*b"));
	}
}
