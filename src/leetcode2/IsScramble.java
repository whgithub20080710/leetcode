package leetcode2;

/**
 * 87. 扰乱字符串 
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * 
 * @author stick
 *
 */
public class IsScramble {

	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2)) {
			return true;
		}

		if (s1.length() == 1) {
			return s1.equals(s2);
		}
		if (s1.length() == 2) {
			String s10 = s1.substring(0, 1);
			String s11 = s1.substring(1, 2);
			String s20 = s2.substring(0, 1);
			String s21 = s2.substring(1, 2);
			return (s10.equals(s20) && s11.equals(s21)) || (s11.equals(s20) && s10.equals(s21));
		}

		if (!isSortSame(s1, s2)) {
			return false;
		}

		int len = s1.length();
		for (int index = 1; index < s1.length(); index++) {
			String s10 = s1.substring(0, index);
			String s11 = s1.substring(index, len);

			String s20 = s2.substring(0, index);
			String s21 = s2.substring(index, len);

			String s22 = s2.substring(0, len - index);
			String s23 = s2.substring(len - index, len);

			// 剪枝 先判断排序后相等
			if (isScramble(s10, s20) && isScramble(s11, s21)) {
				return true;
			}

			if (isScramble(s10, s23) && isScramble(s11, s22)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 比排序验证相等优化一下
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private boolean isSortSame(String s1, String s2) {
		int[] count = new int[26];
		// 判定是否含有相同元素
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		for (int num : count) {
			if (num != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		IsScramble test = new IsScramble();
		System.out.println(test.isScramble("abcde", "caebd"));
	}
}
