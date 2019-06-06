package leetcode2;

import util.TreeNode;

/**
 * 104.二叉树最大深度
 * 给定一个二叉树，找出其最大深度。
 * 
 * @author stick
 *
 */
public class MaxDepth {

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int maxDepth = Math.max(maxDepth(root.left), maxDepth(root.right));
		return maxDepth + 1;
	}
}
