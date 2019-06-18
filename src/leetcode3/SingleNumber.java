package leetcode3;

/**
 * 136.只出现一次的数字 
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * @author stick
 *
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		int ans = nums[0];
		if (nums.length > 1) {
			for (int i = 1; i < nums.length; i++) {
				ans = ans ^ nums[i];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		SingleNumber test = new SingleNumber();
		System.out.println(test.singleNumber(new int[] { 1, 2, 3, 3, 2, 1, 4, 5, 5 }));
	}
}
