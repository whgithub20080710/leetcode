package leetcode2;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @author stick
 *
 */
public class MinPathSum {
	
	public int minPathSum(int[][] grid) {
        if(grid==null){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(i==0) {
                   res[i][j] = j==0?grid[0][0]:res[i][j-1]+grid[i][j];
               }else if(j==0){
                   res[i][j] = i==0?grid[0][0]:res[i-1][j]+grid[i][j];
               }else{
                   res[i][j] = Math.min(res[i][j-1]+grid[i][j], res[i-1][j] +grid[i][j]);
               }
            }
        }
        return res[m-1][n-1];
    }
	
	public static void main(String[] args) {
		MinPathSum test = new MinPathSum();
		System.out.println(test.minPathSum(new int[][] { {1,3,1 }, {1,5,1}, {4,2,1} }));
	}
}
