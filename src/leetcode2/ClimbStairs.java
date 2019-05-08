package leetcode2;

/**
 * 70 . 爬楼梯 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * @author stick
 *
 */
public class ClimbStairs {

	public int climbStairs(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] nums = new int[n + 1];
		nums[1] = 1;
		nums[2] = 2;
		climb(nums, n);
		return nums[n];
	}

	public static void climb(int[] nums, int n) {
		int x = n - 1;
		int y = n - 2;
		if (x > 2 && nums[x] == 0)
			climb(nums, x);
		if (y > 2 && nums[y] == 0)
			climb(nums, y);
		nums[n] = nums[x] + nums[y];
	}
	
	public static void main(String[] args) {
		ClimbStairs test = new ClimbStairs();
		System.out.println(test.climbStairs(4));
	}
}
