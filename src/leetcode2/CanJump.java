package leetcode2;

/**
 * 55. 跳跃游戏 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * @author stick
 *
 */
public class CanJump {

	public boolean canJump(int[] nums) {
		int n = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] >= n) {
				n = 1;
			} else {
				n++;
			}
			if (i == 0 && n > 1) {
				return false;
			}
		}
		return true;
	}

	public boolean canJump2(int[] nums) {
		int maxPlace = 0;
		for (int temp = 0; temp < nums.length && temp <= maxPlace; temp++)
			maxPlace = Math.max(maxPlace, temp + nums[temp]);
		return maxPlace >= nums.length - 1;
	}

	public static void main(String[] args) {
		CanJump test = new CanJump();
		System.out.println(test.canJump(new int[] { 3, 2, 1, 0, 5 }));
		System.out.println(test.canJump2(new int[] { 3, 2, 1, 0, 5 }));
	}
}
