package leetcode3;

/**
 * 191. 位1的个数
 * @author stick
 *
 */
public class HammingWeight {

	public int hammingWeight(int n) {
	    int sum = 0;
	    while (n != 0) {
	        sum++;
	        n &= (n - 1);
	    }
	    return sum;
	}
	
	public static void main(String[] args) {
		HammingWeight test = new HammingWeight();
		System.out.println(test.hammingWeight(8));
	}

}
