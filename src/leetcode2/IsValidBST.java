package leetcode2;

import util.TreeNode;

/**
 * 98. 验证二叉搜索树
 *  给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * @author stick
 *
 */
public class IsValidBST {

	double last = -Double.MAX_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (isValidBST(root.left)) {
			if (last < root.val) {
				last = root.val;
				return isValidBST(root.right);
			}
		}
		return false;
	}
}
