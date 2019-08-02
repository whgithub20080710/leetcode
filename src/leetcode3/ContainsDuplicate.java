package leetcode3;

import java.util.Arrays;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * @author stick
 *
 */
public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		ContainsDuplicate test = new ContainsDuplicate();
		System.out.println(test.containsDuplicate(new int[] {1,2,3,4})); 
	}
}
