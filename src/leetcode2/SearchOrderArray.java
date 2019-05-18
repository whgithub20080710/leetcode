package leetcode2;

/**
 * 81. 搜索旋转排序数组II
 * 
 * @author stick
 *
 */
public class SearchOrderArray {
	public boolean search(int[] nums, int target) {
		boolean ans = bianSear(nums, 0, nums.length - 1, target);
		return ans;
	}

	public boolean bianSear(int[] nums, int first, int last, int target) {
		if (first > last) {
			return false;
		}
		int middle = (last + first) / 2;
		if (nums[middle] == target) {
			return true;
		}
		if (nums[middle] < nums[last]) {// 右边是顺序的
			if (nums[middle] < target && target <= nums[last]) {
				return bianSear(nums, middle + 1, last, target);
			} else {
				return bianSear(nums, first, middle - 1, target);
			}
		} else if (nums[middle] > nums[first]) {// 左边是顺序的
			if (nums[middle] > target && target >= nums[first]) {
				return bianSear(nums, first, middle - 1, target);
			} else {
				return bianSear(nums, middle + 1, last, target);
			}
		} else if (nums[first] == nums[middle]) {// 如果左边跟中间相等则++
			return bianSear(nums, first + 1, last, target);
		} else {// 如果右边个中间相等则--
			return bianSear(nums, first, last - 1, target);
		}

	}
}
