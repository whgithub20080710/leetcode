package leetcode2;

import util.TreeNode;

/**
 * 112. 路径总和 
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * @author stick
 *
 */
public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		sum -= root.val;
		if ((root.left == null) && (root.right == null))
			return (sum == 0);
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}
}
