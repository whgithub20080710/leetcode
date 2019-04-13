package leetcode;

/**
 * 42. 接雨水 
 * 
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1] 输出: 6
 * @author stick
 *
 */
public class RainTrap {

	public int trap(int[] height) {
		int n = height.length;
		int result = 0;
		if (n == 0 || n == 1) {
			return result;
		}
		int left = 0;
		int right = n - 1;
		int leftHeight = 0;
		int rightHeight = 0;
		while (left < right) {
			if (height[left] <= height[right]) {
				leftHeight = Math.max(leftHeight, height[left]);
				result += leftHeight - height[left];
				left++;
			} else {
				rightHeight = Math.max(rightHeight, height[right]);
				result += rightHeight - height[right];
				right--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RainTrap test = new RainTrap();
		System.out.println(test.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}
}
