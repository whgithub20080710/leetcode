package leetcode2;

public class MySqrt {

	public int mySqrt(int x) {
		double t = x;
		double x0 = x;
		x0 = x0 / 2 + t / (2 * x0);
		while (Math.abs(x0 * x0 - t) > 0.00001)
			x0 = x0 / 2 + t / (2 * x0);
		return (int) x0;
	}

	public static void main(String[] args) {
		MySqrt test = new MySqrt();
		System.out.println(test.mySqrt(9));
	}
}
