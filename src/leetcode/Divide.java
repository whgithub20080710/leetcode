package leetcode;

/**
 * 29. 两数相除 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3 输出: 3
 * 
 * @author stick
 *
 */
public class Divide {
	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		boolean negative;
		negative = (dividend ^ divisor) < 0;// 用异或来计算是否符号相异
		long absDividend = Math.abs((long) dividend);
		long absDivisor = Math.abs((long) divisor);
		int result = 0;
		for (int i = 31; i >= 0; i--) {
			if ((absDividend >> i) >= absDivisor) {// 找出足够大的数2^n*divisor
				result += 1 << i;// 将结果加上2^n
				absDividend -= absDivisor << i;// 将被除数减去2^n*divisor
			}
		}
		return negative ? -result : result;// 符号相异取反
	}
	
	public static void main(String[] args) {
		Divide test = new Divide();
		System.out.println(test.divide(10, 10));
	}
}
