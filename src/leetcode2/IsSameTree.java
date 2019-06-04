package leetcode2;

import util.TreeNode;

/**
 * 100. 相同的树 
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * @author stick
 *
 */
public class IsSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// p 和 q 均为 null时
		if (p == null && q == null)
			return true;
		// p 或 q 有一个为null时
		if (q == null || p == null)
			return false;
		if (p.val != q.val)
			return false;
		return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
	}
}
