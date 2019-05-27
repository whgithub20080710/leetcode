package leetcode2;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组 
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 
 * @author stick
 *
 */
public class MergeArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// 先归并大的，这样一遍扫面即可。
		for (int k = m + n - 1, i = m - 1, j = n - 1; k >= 0; k--) {
			if (i < 0) {
				nums1[k] = nums2[j--];
				continue;
			}
			if (nums1[i] >= nums2[j])
				nums1[k] = nums1[i--];
			else
				nums1[k] = nums2[j--];
		}
	}

	public static void main(String[] args) {
		MergeArray test = new MergeArray();
		int[] nums1 = new int[] { 1, 2, 7, 0, 0, 0 };
		test.merge(nums1, 3, new int[] { 2, 5, 6 }, 3);
		System.out.println(Arrays.toString(nums1));
	}

}
