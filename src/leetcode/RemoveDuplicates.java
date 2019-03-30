package leetcode;

/**
 * 26. 删除排序数组中的重复项 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 
 * 示例 1:
 * 
 * 给定数组 nums = [1,1,2],
 * 
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * @author stick
 *
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		int result = 0;
		if (nums != null && nums.length > 0) {
			result = 1;
			if (nums.length == 1) {
			} else {
				int flag = nums[0];
				for (int i = 1; i < nums.length; i++) {
					if (nums[i] == flag) {
					} else {
						flag = nums[i];
						nums[result] = nums[i];
						result++;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RemoveDuplicates test = new RemoveDuplicates();
		System.out.println(test.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}
}
