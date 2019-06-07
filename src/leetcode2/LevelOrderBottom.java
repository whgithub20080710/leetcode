package leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/**
 * 107. 二叉树的层次遍历 II 
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * @author stick
 *
 */
public class LevelOrderBottom {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(root, 0, res);
		Collections.reverse(res);
		return res;
	}

	public void helper(TreeNode root, int depth, List<List<Integer>> res) {
		if (root == null)
			return;
		if (depth + 1 > res.size())
			res.add(new ArrayList());
		res.get(depth).add(root.val);
		if (root.left != null)
			helper(root.left, depth + 1, res);
		if (root.right != null)
			helper(root.right, depth + 1, res);
	}

	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			res.add(temp);
		}
		Collections.reverse(res);
		return res;
	}

}
