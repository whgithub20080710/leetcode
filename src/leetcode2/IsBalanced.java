package leetcode2;

import util.TreeNode;

/**
 * 110. 平衡二叉树 
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * @author stick
 *
 */
public class IsBalanced {

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = depth(root.left);
		int rightDepth = depth(root.right);
		return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
	}

}
