package leetcode2;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * @author stick
 *
 */
public class ArrayExistWord {
	public boolean exist(char[][] board, String word) {
		char[] target = word.toCharArray();
		int m = board.length;
		int n = board[0].length;
		int[][] visit = new int[m][n];// 用于存放是否访问过
		boolean ans = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				visit[i][j] = -1;
			}
		}
		here: for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((board[i][j]) == target[0]) {
					ans = bps(board, visit, target, i, j, 0);
					if (ans == true) {
						break here;
					}
				}
			}
		}

		return ans;
	}

	public boolean bps(char[][] board, int[][] visit, char[] target, int i, int j, int count) {
		if (count == target.length) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j] != -1
				|| board[i][j] != target[count]) {// 判出界条件
			return false;
		} else {
			visit[i][j] = 1;// 访问后置为已经访问
			boolean ans = bps(board, visit, target, i + 1, j, count + 1)
					|| bps(board, visit, target, i - 1, j, count + 1) || bps(board, visit, target, i, j + 1, count + 1)
					|| bps(board, visit, target, i, j - 1, count + 1);
			visit[i][j] = -1;// 返回后置为未访问
			return ans;
		}
	}

	public static void main(String[] args) {
		ArrayExistWord test = new ArrayExistWord();
		System.out.println(test.exist(new char[][] { { 'a', 'b' }, { 'c', 'd' } }, "ac"));
	}
}
