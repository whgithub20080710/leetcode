package leetcode;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @author stick
 *
 */
public class StrMultiply {

	public String multiply(String num1, String num2) {
		if (num1.length() < 0 || num2.length() < 0)
			return "";
		if (num1.equals("0") || num2.equals("0"))
			return "0";

		int[] res = new int[num1.length() + num2.length()];
		StringBuilder sb = new StringBuilder();
		for (int j = num2.length() - 1, count = 0; j >= 0; --j) {
			mul(num1, num2.charAt(j), res, count++);
		}
		int start = 0;
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0) {
				start = i;
				break;
			}
		}
		for (int i = start; i < res.length; i++) {
			sb.append(res[i]);
		}
		return sb.toString();
	}

	public void mul(String num1, char a, int[] res, int index) {
		int j = res.length - 1 - index;
		for (int i = num1.length() - 1; i >= 0; --i) {
			int mul = (num1.charAt(i) - '0') * (a - '0') + res[j];
			res[j] = mul % 10;
			res[j - 1] += mul / 10;
			j--;
		}
	}

	public static void main(String[] args) {
		StrMultiply test = new StrMultiply();
		System.out.println(test.multiply("123", "11"));
	}
}
