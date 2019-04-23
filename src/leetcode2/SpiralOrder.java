package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵 
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * @author stick
 *
 */
public class SpiralOrder {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return list;
		int tr = 0, br = matrix.length - 1;
		int tc = 0, bc = matrix[0].length - 1;
		while (tr <= br && tc <= bc) {
			// 从左到右
			for (int i = tc; i <= bc; i++) {
				list.add(matrix[tr][i]);
			}
			// 从上到下, 超过一行才打印
			for (int i = tr + 1; i <= br; i++) {
				list.add(matrix[i][bc]);
			}
			// 从右到左，超过一行打印
			for (int i = bc - 1; i >= tc && br != tr; i--) {
				list.add(matrix[br][i]);
			}
			// 从下到上, 超过一列才打印
			for (int i = br - 1; i >= tr + 1 && bc != tc; i--) {
				list.add(matrix[i][tc]);
			}
			tr++;
			tc++;
			br--;
			bc--;
		}
		return list;
	}

	public static void main(String[] args) {
		SpiralOrder test = new SpiralOrder();
		System.out.println(test.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }).toString());
	}
}
