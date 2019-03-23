package leetcode;

/**
 * 14.最长公共前缀 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"] 输出: "fl"
 * 
 * @author stick
 *
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String firstStr = strs[0];
		int len = firstStr.length();
		boolean allMatch = true;
		int i = 0;
		for (; i < len; i++) {
			int j = 1;
			do {
				if (strs[j].startsWith(firstStr.substring(0, i + 1))) {
					j++;
				} else {
					allMatch = false;
					break;
				}
			} while (j < strs.length);

			if (!allMatch) {
				break;
			}

		}
		return i > 0 ? firstStr.substring(0, i) : "";
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	public static void main(String[] args) {
		LongestCommonPrefix test = new LongestCommonPrefix();
		System.out.println(test.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
	}

}
