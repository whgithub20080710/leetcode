package leetcode;

import java.util.Arrays;

/**
 * 1.两数之和 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * @author stick
 *
 */
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= target) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] + nums[j] == target) {
						result[0] = i;
						result[1] = j;
						break;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 5, 7, 11 };
		int target = 10;
		int[] result = twoSum(nums, target);
		System.out.println(Arrays.toString(result));
	}
}
