package leetcode2;

import util.TreeNode;

/**
 * 98. 验证二叉搜索树 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
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
				System.out.println(last);
				return isValidBST(root.right);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		t2.left = t1;
		t2.right = t3;
		t8.right = t9;
		t7.left = t6;
		t7.right = t8;
		t5.left = t2;
		t5.right = t7;
		System.out.println(new IsValidBST().isValidBST(t5));
	}
}
