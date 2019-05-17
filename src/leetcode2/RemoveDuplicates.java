package leetcode2;

/**
 * 80. 删除排序数组中的重复项II 
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 
 * @author stick
 *
 */
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}

	public static void main(String[] args) {
		RemoveDuplicates test = new RemoveDuplicates();
		System.out.println(test.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
	}
}
