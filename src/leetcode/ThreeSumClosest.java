package leetcode;

/**
 * 
 * @author stick
 *
 */
public class ThreeSumClosest {
	public int threeSumClosest2(int[] nums, int target) {
		int result = nums[0] + nums[1] + nums[2];
		int distance = Math.abs(target - result);
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (Math.abs(target - (nums[i] + nums[j] + nums[k])) < distance) {
						result = nums[i] + nums[j] + nums[k];
						if (target == result) {
							return result;
						} else {
							distance = Math.abs(target - (nums[i] + nums[j] + nums[k]));
						}
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ThreeSumClosest test = new ThreeSumClosest();
		System.out.println(test.threeSumClosest2(new int[] { -1, 2, 1, -4 }, 1));
	}
}
