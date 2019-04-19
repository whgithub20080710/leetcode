package leetcode;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 
 * @author stick
 *
 */
public class RotateArray {

	public void rotate(int[][] matrix) {
		rotate(matrix, 0);
	}

	private void rotate(int[][] matrix, int index) {
		int val = matrix.length % 2 == 0 ? matrix.length / 2 : matrix.length / 2 + 1;
		if (index >= val) {
			return;
		}
		for (int i = index; i < matrix.length - 1 - index; i++) {
			int temp = matrix[matrix.length - 1 - index][i];
			matrix[matrix.length - 1 - index][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - index];
			matrix[matrix.length - 1 - i][matrix.length - 1 - index] = matrix[index][matrix.length - 1 - i];
			matrix[index][matrix.length - 1 - i] = matrix[i][index];
			matrix[i][index] = temp;
		}
		rotate(matrix, index + 1);
	}
	
	public static void main(String[] args) {
		int[] r1 = new int[]{1,2,3,11};
		int[] r2 = new int[]{4,5,6,12};
		int[] r3 = new int[]{7,8,9,13};
		int[] r4 = new int[]{10,14,15,16};
		int[][] testArr = new int[][]{r1,r2,r3,r4};
		RotateArray test = new RotateArray();
		test.rotate(testArr);
		System.out.println(Arrays.toString(testArr[0]));
		System.out.println(Arrays.toString(testArr[1]));
		System.out.println(Arrays.toString(testArr[2]));
		System.out.println(Arrays.toString(testArr[3]));
	}
}
