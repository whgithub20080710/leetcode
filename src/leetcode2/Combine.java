package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合 
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * @author stick
 *
 */
public class Combine {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> subList = new ArrayList<>();

		add(list, subList, 1, n, k);
		return list;
	}

	private void add(List<List<Integer>> list, List<Integer> subList, int start, int n, int k) {
		if (k <= 0) {
			ArrayList<Integer> tmpList = new ArrayList<>(subList);
			list.add(tmpList);
			return;
		}
		while (start <= n - k + 1) {
			subList.add(start);
			add(list, subList, start + 1, n, k - 1);
			subList.remove(subList.size() - 1);
			start += 1;
		}
	}

	public static void main(String[] args) {
		Combine test = new Combine();
		System.out.println(test.combine(5, 3).toString());
	}
}
