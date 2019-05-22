package leetcode2;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形 
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * @author stick
 *
 */
public class LargestRectangleArea {

	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
				int cur = stack.pop();
				int len = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, len * heights[cur]);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			int len = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
			max = Math.max(max, len * heights[cur]);
		}
		return max;
	}

	public static void main(String[] args) {
		LargestRectangleArea test = new LargestRectangleArea();
		System.out.println(test.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
	}
}
