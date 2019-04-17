package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列 
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * @author stick
 *
 */
public class PermuteI {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		recPer(nums, new Integer[nums.length], result, nums.length, 0);
		return result;
	}

	void swap(int[] nums, int A, int B) {
		int temp = nums[A];
		nums[A] = nums[B];
		nums[B] = temp;
	}

	public void recPer(int[] nums, Integer[] lastList, List<List<Integer>> result, int len, int place) {
		for (int temp = 0; temp < len; temp++) {
			lastList[place] = nums[temp];
			if (place + 1 != nums.length) {
				swap(nums, temp, len - 1); // 把当前元素与数组尾交换
				recPer(nums, lastList, result, len - 1, place + 1);
				swap(nums, temp, len - 1); // 还原数组

			} else {
				result.add(Arrays.asList(lastList.clone()));
			}
		}
	}

	public static void main(String[] args) {
		PermuteI test = new PermuteI();
		System.out.println(test.permute(new int[] { 1, 2, 3 }).toString());
	}
}
