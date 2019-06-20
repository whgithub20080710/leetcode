package leetcode3;

/**
 * 167. 两数之和II 给
 * 定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 
 * @author stick
 *
 */
public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			if (numbers[i] + numbers[j] == target) {
				result[0] = i + 1;
				result[1] = j + 1;
				break;
			} else {
				if (numbers[i] + numbers[j] < target) {
					i++;
				} else {
					j--;
				}
			}
		}
		return result;
	}
}
