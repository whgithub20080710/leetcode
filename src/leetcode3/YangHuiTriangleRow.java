package leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * 119.杨辉三角II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * @author stick
 *
 */
public class YangHuiTriangleRow {

	/**
	 * 获取杨辉三角的指定行 
	 * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!) 
	 * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>(rowIndex + 1);
		long cur = 1;
		for (int i = 0; i <= rowIndex; i++) {
			res.add((int) cur);
			cur = cur * (rowIndex - i) / (i + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		YangHuiTriangleRow test = new YangHuiTriangleRow();
		System.out.println(test.getRow(7).toString());
	}
}
