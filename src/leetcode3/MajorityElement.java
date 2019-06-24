package leetcode3;

import java.util.Arrays;

/**
 * 众数
 * @author stick
 *
 */
public class MajorityElement {

	public int majorityElement(int[] nums) {
		int majorityCount = nums.length / 2;

		for (int num : nums) {
			int count = 0;
			for (int elem : nums) {
				if (elem == num) {
					count += 1;
				}
			}

			if (count > majorityCount) {
				return num;
			}

		}

		return -1;
	}
	
	public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
