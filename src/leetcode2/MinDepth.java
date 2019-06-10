package leetcode2;

import util.TreeNode;

/**
 * 111. 二叉树最小深度 
 * 给定一个二叉树，找出其最小深度。
 * 
 * @author stick
 *
 */
public class MinDepth {

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}
}
