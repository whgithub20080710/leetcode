package leetcode3;

/**
 * 172. 阶乘后的零 
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 
 * @author stick
 *
 */
public class TrailingZeroes {

	public int trailingZeroes(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}

	public static void main(String[] args) {
		TrailingZeroes test = new TrailingZeroes();
		System.out.println(test.trailingZeroes(10));
	}
}
