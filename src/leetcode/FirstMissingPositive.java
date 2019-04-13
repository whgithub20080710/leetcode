package leetcode;

/**
 * 41. 缺失的第一个正数 
 * 
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0] 输出: 3
 * 
 * @author stick
 *
 */
public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length;) {
			if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
				int index = nums[i];//
				nums[i] = nums[index - 1];
				nums[index - 1] = index;
			} else {
				i++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	public static void main(String[] args) {
		FirstMissingPositive test = new FirstMissingPositive();
		System.out.println(test.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
	}
}
