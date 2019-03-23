package leetcode;

/**
 * 7.整数反转 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * @author stick
 *
 */
public class IntReverse {
	public int reverse(int x) {
		int result = 0;
		boolean negative = false;
		if (x < 0) {
			negative = true;
			x = x * -1;
		}
		while (x > 0) {
			int end = x % 10;
			if (result > 214748364) {
				return 0;
			}
			if (result == 214748364) {
				if (!negative && end > 7) {
					return 0;
				} else if (end > 8) {
					return 0;
				}
			}
			result = result * 10 + end;
			x /= 10;
		}
		if (negative) {
			result = result * -1;
		}
		return result;
	}

	public static void main(String[] args) {
		IntReverse test = new IntReverse();
		System.out.println(test.reverse(1534236469));
	}
}
