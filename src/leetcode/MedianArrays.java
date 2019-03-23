package leetcode;

import java.util.Arrays;

/**
 * 4.寻找两个有序数组的中位数 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * @author stick
 *
 */
public class MedianArrays {

	public static double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		if (m > n) { // to ensure m<=n
			int[] temp = A;
			A = B;
			B = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j - 1] > A[i]) {
				iMin = i + 1; // i is too small
			} else if (i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1; // i is too big
			} else { // i is perfect
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}

				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

	public static double findMedianSortedArrays2(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int len = m + n;
		int[] totalArrays = new int[len];
		if (m == 0) {
			totalArrays = B;
			if (len % 2 == 0) {
				return (totalArrays[totalArrays.length / 2] + totalArrays[totalArrays.length / 2 - 1]) / 2d;
			} else {
				return totalArrays[totalArrays.length / 2];
			}
		}
		if (n == 0) {
			totalArrays = A;
			if (len % 2 == 0) {
				return (totalArrays[totalArrays.length / 2] + totalArrays[totalArrays.length / 2 - 1]) / 2d;
			} else {
				return totalArrays[totalArrays.length / 2];
			}
		}
		int ai = 0, bi = 0;
		for (int i = 0; i < len; i++) {
			if (bi != n) {
				if (ai != m && A[ai] <= B[bi]) {
					totalArrays[i] = A[ai];
					ai++;
				} else {
					totalArrays[i] = B[bi];
					bi++;
				}
			} else {
				totalArrays[i] = A[ai];
				ai++;
			}
		}
		System.out.println(Arrays.toString(totalArrays));
		if (len % 2 == 0) {
			return (totalArrays[totalArrays.length / 2] + totalArrays[totalArrays.length / 2 - 1]) / 2d;
		} else {
			return totalArrays[totalArrays.length / 2];
		}
	}

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays2(new int[] { 1, 2, 2, 2, 3 }, new int[] { 4, 5, 6 }));
	}
}
