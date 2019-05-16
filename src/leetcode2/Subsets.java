package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集 
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * @author stick
 *
 */
public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, nums, new ArrayList<>(), 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int deep) {
		if (deep >= nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}

		temp.add(nums[deep]);
		dfs(res, nums, temp, deep + 1);
		temp.remove(temp.size() - 1);
		dfs(res, nums, temp, deep + 1);
	}

	public static void main(String[] args) {
		Subsets test = new Subsets();
		System.out.println(test.subsets(new int[] { 1, 2, 3 }).toString());
	}
}
