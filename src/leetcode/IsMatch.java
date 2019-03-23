package leetcode;

/**
 * 10.正则表达式匹配 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * 
 * '.' 匹配任意单个字符。 '*' 匹配零个或多个前面的元素。 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * 
 * 说明:
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。 p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 
 * @author stick
 *
 */
public class IsMatch {
	public boolean isMatch(String s, String p) {
		int sLen = s.length(), pLen = p.length();
		boolean[][] memory = new boolean[sLen + 1][pLen + 1];
		memory[0][0] = true;
		for (int i = 0; i <= sLen; i++) {
			for (int j = 1; j <= pLen; j++) {
				if (p.charAt(j - 1) == '*') {
					memory[i][j] = memory[i][j - 2] || (i > 0
							&& (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && memory[i - 1][j]);
				} else {
					memory[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
							&& memory[i - 1][j - 1];
				}
			}
		}
		return memory[sLen][pLen];
	}

	/**
	 * 自己写的有bug
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch2(String s, String p) {
		int sLen = s.length(), pLen = p.length(), sIndex = 0, pIndex = 0;
		for (int i = 0; i < pLen; i++) {
			pIndex++;
			char nowChar = p.charAt(i);
			if ('*' == nowChar) {
				char beforeChar = p.charAt(i - 1);
				while (sIndex < sLen) {
					if (beforeChar == s.charAt(sIndex) || '.' == nowChar) {
						sIndex++;
					} else {
						break;
					}
				}
			} else if ('.' == nowChar) {
				sIndex++;
			} else {
				if (sIndex < sLen && nowChar == s.charAt(sIndex)) {
					sIndex++;
				} else {
					return false;
				}
			}
		}
		return sIndex == sLen && pIndex == pLen;
	}

	public static void main(String[] args) {
		IsMatch test = new IsMatch();
		System.out.println(test.isMatch2("aac", "aab"));
	}

}
