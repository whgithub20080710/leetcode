package leetcode2;

/**
 * 67. 二进制求和
 *  给定两个二进制字符串，返回他们的和（用二进制表示）。
 * @author stick
 *
 */
public class AddBinary {

	public String addBinary(String a, String b) {
		int la = a.length(), lb = b.length();
		int n = Math.max(la, lb), c1, c2, c3 = 0, c4;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			c1 = (i < la) ? a.charAt(la - 1 - i) - '0' : 0;
			c2 = (i < lb) ? b.charAt(lb - 1 - i) - '0' : 0;
			c4 = c1 + c2 + c3;
			c3 = c4 / 2;
			sb.append(c4 % 2);
		}
		if (sb.charAt(n) == '0') {
			sb.deleteCharAt(n);// 删掉最高位的0
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		AddBinary test = new AddBinary();
		System.out.println(test.addBinary("11", "101"));
	}
}
