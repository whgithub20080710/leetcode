package leetcode;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5 输出: 2
 * 
 * @author stick
 *
 */
public class SearchInsert {
	public int searchInsert(int[] nums, int target) {
		return search(nums, target, 0, nums.length);
	}

	public int search(int[] nums, int target, int begin, int end) {
		int mid = (begin + end) / 2;
		if (mid == end || nums[mid] == target) {
			return mid;
		}
		return target < nums[mid] ? search(nums, target, begin, mid) : search(nums, target, mid + 1, end);
	}
	
	public static void main(String[] args) {
		SearchInsert test = new SearchInsert();
		System.out.println(test.searchInsert(new int[]{1,3,5,6}, 5));
	}
}
