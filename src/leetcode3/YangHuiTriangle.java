package leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角 
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * @author stick
 *
 */
public class YangHuiTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		// 特殊情况0.
		if (numRows == 0) {
			return triangle;
		}

		// 第一行永远是1.
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);

		for (int rowNum = 1; rowNum < numRows; rowNum++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(rowNum - 1);

			// 每行第一个永远是 1.
			row.add(1);

			// 中间的元素等于上一行相邻元素的和
			for (int j = 1; j < rowNum; j++) {
				row.add(prevRow.get(j - 1) + prevRow.get(j));
			}

			// 最后一行永远是 1.
			row.add(1);

			triangle.add(row);
		}

		return triangle;
	}
}
