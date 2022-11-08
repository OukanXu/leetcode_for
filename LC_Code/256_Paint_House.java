package LC_Code;


class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        dp[0] = costs[0];

        for(int i = 1; i < costs.length; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];
        }

        int min = Math.min(dp[costs.length-1][0],dp[costs.length-1][1]);
        min = Math.min(dp[costs.length-1][2],min);
        return min;
    }
}