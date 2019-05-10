package leetcode2;

import java.util.Arrays;

/**
 * 73.矩阵置零 
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 
 * @author stick
 *
 */
public class SetZeroes {

	public void setZeroes(int[][] matrix) {
		boolean rowFlag = false;
		// 判断首行
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				rowFlag = true;
				break;
			}
		}

		boolean colFlag = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colFlag = true;
				break;
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		if (rowFlag) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
		if (colFlag) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		SetZeroes test = new SetZeroes();
		int[][] result = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		test.setZeroes(result);
		System.out.println(Arrays.deepToString(result));
	}
}
