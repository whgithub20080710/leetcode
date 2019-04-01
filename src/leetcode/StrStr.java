package leetcode;

/**
 * 28. 实现strStr() 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll" 输出: 2
 * 
 * @author stick
 *
 */
public class StrStr {

	/**
	 * 原本思路
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		int result = -1;
		if ("".equals(needle)) {
			return 0;
		}
		char[] haystackArray = haystack.toCharArray();
		char[] needleArray = needle.toCharArray();
		if (haystackArray.length < needleArray.length) {
			return result;
		}
		for (int i = 0; i < haystackArray.length; i++) {
			if (haystackArray[i] == needleArray[0]) {
				result = i;
				for (int j = 1; j < needleArray.length; j++) {
					if (i + j >= haystackArray.length || haystackArray[i + j] != needleArray[j]) {
						result = -1;
					}
				}
				if (result != -1) {
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 使用java indexof方法的思路
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int indexOf(String a, String b) {
		char[] source = a.toCharArray();
		int sourceCount = source.length;
		char[] target = b.toCharArray();
		int targetCount = target.length;

		if (targetCount == 0) {
			return 0;
		}
		if (sourceCount < targetCount) {
			return -1;
		}

		char first = target[0];
		int max = (sourceCount - targetCount);

		for (int i = 0; i <= max; i++) {
			if (source[i] != first) {
				while (++i <= max && source[i] != first)
					;
			}

			if (i <= max) {
				int j = i + 1;
				int end = j + targetCount - 1;
				for (int k = 1; j < end && source[j] == target[k]; j++, k++)
					;

				if (j == end) {
					/* Found whole string. */
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		StrStr test = new StrStr();
		"".indexOf("");
		System.out.println(test.strStr("aaaaa", ""));
	}
}
