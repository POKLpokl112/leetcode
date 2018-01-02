package code.two;

//Follow up for "Unique Paths":
//
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//For example,
//There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//The total number of unique paths is 2.
//
//Note: m and n will be at most 100.
public class UniquePathsWithObstacles_dont_un_dp {
	public int uniquePathsWithObstacles(final int[][] obstacleGrid) {
		final int[] dp = new int[obstacleGrid[0].length];
		dp[0]=1;
		for (final int[] is : obstacleGrid) {
			for (int i = 0; i < is.length; i++) {
				if (is[i] == 1) {
					dp[i] = 0;
				} else if (i > 0) {
					dp[i] += dp[i - 1];
				}
			}
		}

		return dp[obstacleGrid[0].length - 1];
	}

}
