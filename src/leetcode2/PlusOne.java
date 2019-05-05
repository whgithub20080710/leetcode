package leetcode2;

import java.util.Arrays;

/**
 * 66.加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * @author stick
 *
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
		int carry;
		int[] results = new int[digits.length];
		carry = (digits[digits.length - 1] + 1) / 10;
		results[results.length - 1] = (digits[digits.length - 1] + 1) % 10;
		for (int i = digits.length - 2; i >= 0; i--) {
			int ri = digits[i] + carry;
			results[i] = ri % 10;
			carry = ri / 10;
		}
		if (carry > 0) {
			int[] newResults = new int[results.length + 1];
			System.arraycopy(results, 0, newResults, 1, results.length);
			newResults[0] = carry;
			return newResults;
		}
		return results;
	}

	public static void main(String[] args) {
		PlusOne test = new PlusOne();
		System.out.println(Arrays.toString(test.plusOne(new int[] { 9, 9, 9 })));
	}

}
