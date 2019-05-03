package leetcode2;

/**
 * 63.不同路径II 
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * @author stick
 *
 */
public class UniquePathsWithObstacles {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[i].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = 0;
					continue;
				}
				if (i == 0 && j == 0) {
					obstacleGrid[i][j] = 1;
					continue;
				}
				if (i == 0 || j == 0) {
					obstacleGrid[i][j] = i == 0 ? obstacleGrid[i][j - 1] : obstacleGrid[i - 1][j];
					continue;
				}
				obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
			}
		}
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

	public static void main(String[] args) {
		UniquePathsWithObstacles test = new UniquePathsWithObstacles();
		System.out.println(test.uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
	}

}
