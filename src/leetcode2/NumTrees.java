package leetcode2;

/**
 * 96. 不同的二叉搜索树
 *  给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 
 * @author stick
 *
 */
public class NumTrees {
	public int numTrees(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] total = new int[n + 1];
		total[0] = 1;
		total[1] = 2;
		return numTrees(1, n, total);
	}

	public int numTrees(int start, int end, int[] total) {
		if (total[end - start] != 0) {
			return total[end - start];
		}
		int sum = 0;
		for (int mid = start; mid <= end; mid++) {
			int left = 1;
			int right = 1;
			if (start != mid) {
				// 说明有左子树
				left = numTrees(start, mid - 1, total);
			}
			if (end != mid) {
				// 说明有右子树
				right = numTrees(mid + 1, end, total);
			}
			sum += left * right;

		}
		total[end - start] = sum;
		return sum;
	}
}
