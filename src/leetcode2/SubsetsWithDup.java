package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II 
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 
 * @author stick
 *
 */
public class SubsetsWithDup {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		subsets(nums, 0, new ArrayList<>(), result);
		result.add(new ArrayList<>());
		return result;
	}

	public void subsets(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
		if (index == nums.length) {
			return;
		}
		for (int i = index; i < nums.length; i++) {
			// 不同点就是来个判重
			if (i > index && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			result.add(new ArrayList<>(temp));
			subsets(nums, i + 1, temp, result);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		SubsetsWithDup test = new SubsetsWithDup();
		System.out.println(test.subsetsWithDup(new int[] { 1, 2, 3 }).toString());
	}
}
