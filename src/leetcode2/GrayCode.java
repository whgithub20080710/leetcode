package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 *  格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * 
 * @author stick
 *
 */
public class GrayCode {
	boolean[] v = new boolean[65537];

	public List<Integer> grayCode(int n) {

		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(0);
		v[0] = true;
		dfs(n, 0, ans);
		return ans;
	}

	/**
	 * 利用递归，但不能回溯，因为不是找排列组合，而是找到跟当前差一位的 另一个数字之后标记一下就可以break了。
	 * 
	 * 使用位运算，1左移i位之后取异或即将数字该位上的值取反
	 * 
	 * @param n
	 *            格雷码位数
	 * @param curr
	 *            进行变换的当前数字
	 * @param ans
	 *            返回答案列表
	 */
	public void dfs(int n, int curr, List<Integer> ans) {

		for (int i = 0; i < n; i++) {
			curr = 1 << i ^ curr;
			if (!v[curr]) {
				v[curr] = true;
				ans.add(curr);
				dfs(n, curr, ans);
				break;
			}
			// 此处由于用curr记录了一下变换后的数字，若该数字已经出现过，
			// 则curr再次循环时已经不是之前的curr，所以再一次异或将其还原
			// 如果再加一个其他变量来记录一下可能更好理解，可以如下替换
			/**
			 * for(int i=0; i<n; i++){ int new_curr = 1<<i ^ curr if
			 * (!v[new_curr]){ v[new_curr] = true; ans.add(new_curr); dfs(n,
			 * new_curr, ans); break; } }
			 * 
			 * 此时后边不用再加 curr = 1<<i ^ curr
			 */

			curr = 1 << i ^ curr;
		}
	}
}
