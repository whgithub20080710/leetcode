package leetcode2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

/**
 * 94.二叉树中序遍历
 * 
 * @author stick
 *
 */
public class InorderTraversal {

	/**
	 * 方法1：递归
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Integer> result = new ArrayList<>();
		result.addAll(inorderTraversal(root.left));
		result.add(root.val);
		result.addAll(inorderTraversal(root.right));
		return result;
	}

	/**
	 * 方法2： 将节点左子树全部压栈 若当前元素有右子树， 则将当前元素加入遍历结果 指向当前节点右子树 若当前节点为空，
	 * 则结束遍历；若当前节点不为空， 则继续循环上述操作
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		Stack<TreeNode> treeNodeStack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		TreeNode node = root;
		while (node != null) {
			while (node != null) {
				treeNodeStack.push(node);
				node = node.left;
			}
			while (treeNodeStack.size() > 0 && (node = treeNodeStack.pop()).right == null) {
				result.add(node.val);
			}
			// node不可能为null
			if (node.right != null) {
				result.add(node.val);
			}
			node = node.right;
		}
		return result;
	}

	/**
	 * 方法3：将节点左子树全部压栈 如果栈不为空则弹出栈顶元素并将其加入遍历结果，指向当前节点右子树
	 * 若当前节点和栈均为空，则结束遍历；否则继续循环上述操作
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal3(TreeNode root) {
		Stack<TreeNode> treeNodeStack = new Stack<>();
		List<Integer> result = new ArrayList<>();
		TreeNode node = root;
		while (node != null || !treeNodeStack.isEmpty()) {
			while (node != null) {
				treeNodeStack.push(node);
				node = node.left;
			}
			if (!treeNodeStack.isEmpty()) {
				node = treeNodeStack.pop();
				result.add(node.val);
				node = node.right;
			}
		}
		return result;
	}
}
