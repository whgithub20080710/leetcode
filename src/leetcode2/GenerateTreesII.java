package leetcode2;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * 95. 不同的二叉搜索树 
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 
 * @author stick
 *
 */
public class GenerateTreesII {
	public List<TreeNode> generateTrees(int n) {
		if (n <= 0) {
			return new ArrayList<>();
		}
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {
		if (start == end) {
			List<TreeNode> list = new ArrayList<>();
			TreeNode node = new TreeNode(start);
			list.add(node);
			return list;
		}
		// 已mid为根节点 左右子树分别为start到mid-1 和 mid+1到end 注意边界
		List<TreeNode> res = new ArrayList<>();
		for (int mid = start; mid <= end; mid++) {
			List<TreeNode> left = new ArrayList<>();
			List<TreeNode> right = new ArrayList<>();
			if (start != mid) {
				// 说明有左子树
				left = generateTrees(start, mid - 1);
			}
			if (end != mid) {
				// 说明有右子树
				right = generateTrees(mid + 1, end);
			}
			if (!left.isEmpty() && !right.isEmpty()) {
				for (TreeNode l : left) {
					for (TreeNode r : right) {
						TreeNode root = new TreeNode(mid);
						root.left = l;
						root.right = r;
						res.add(root);
					}
				}
			} else if (!left.isEmpty()) {
				for (TreeNode l : left) {
					TreeNode root = new TreeNode(mid);
					root.left = l;
					res.add(root);
				}
			} else if (!right.isEmpty()) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(mid);
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
}
