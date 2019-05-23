package leetcode2;

/**
 * 85. 最大矩形
 *  给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * @author stick
 *
 */
public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {
		int res = 0;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		// 用于存放最当前的高
		int[][] matrixint = new int[matrix.length][matrix[0].length];
		// 第一层的高度是当前的数字最高为1
		for (int i = 0; i < matrix[0].length; i++) {
			matrixint[0][i] = matrix[0][i] - 48;
		}
		// 循环所有一行一行的向下来计算每行的高度（一行一行的截取矩形的高度）
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				// 如果为零说明断开不能与上一层相连
				if (matrix[i][j] == '0') {
					matrixint[i][j] = 0;
				} else {
					// 不为零则进行计算加上本身的1
					matrixint[i][j] = matrixint[i - 1][j] + 1;
				}
			}
		}
		// 每一行都可以看做是一个底 一行一行的进行算面积（知道高了找到相应最大的宽就好了）
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				// 大于零的高有意义
				if (matrixint[i][j] > 0) {
					// 定义两个指针进行搜索宽
					int left = j - 1;
					int right = j + 1;
					int wide = 1;
					// 搜索每一个高比当前中间这个高的值（向左可以组成矩形）
					while (left >= 0 && matrixint[i][left] >= matrixint[i][j]) {
						left--;
						wide++;
					}
					while (right < matrixint[0].length && matrixint[i][right] >= matrixint[i][j]) {
						right++;
						wide++;
					}
					// 计算面积
					int air = matrixint[i][j] * wide;
					if (air > res) {
						res = air;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MaximalRectangle test = new MaximalRectangle();
		System.out.println(test.maximalRectangle(new char[][] { { '0', '1' }, { '0', '1' }, { '0', '0' } }));
	}
}
