package leetcode3;

import java.util.Arrays;
import java.util.Random;

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
	
	private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement3(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length/2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
    
    public int majorityElement4(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    
    
	
	
}
