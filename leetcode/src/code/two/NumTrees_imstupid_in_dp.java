package code.two;

public class NumTrees_imstupid_in_dp {
	public int numTrees(final int n) {
		final int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}
}

// int [] dp = new int[n+1];
// dp[0]= 1;
// dp[1] = 1;
// for(int level = 2; level <=n; level++)
// for(int root = 1; root<=level; root++)
// dp[level] += dp[level-root]*dp[root-1];
// return dp[n];