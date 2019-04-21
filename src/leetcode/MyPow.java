package leetcode;

/**
 * 50. Pow(x, n) 
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * @author stick
 *
 */
public class MyPow {

	public double myPow(double x, int n) {
		if (n == 0) {
			return (double) 1;
		}

		if (n == 1) {
			return x;
		} else if (n == -1) {
			return 1 / x;
		}

		if ((n % 2) == 0) {
			double r = myPow(x, n / 2);
			return r * r;
		} else {
			double r = myPow(x, n / 2);
			return r * r * (n > 0 ? x : 1 / x);
		}

	}

	public static void main(String[] args) {
		MyPow test = new MyPow();
		System.out.println(test.myPow(2, 10));
	}
}
