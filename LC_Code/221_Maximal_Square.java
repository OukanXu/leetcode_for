class Solution {
    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height][width];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < width; i++){
            dp[0][i] = matrix[0][i] == '1' ? 1: 0;
            max = Math.max(dp[0][i],max);
        }

        for(int i = 0; i < height; i++){
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(dp[i][0],max);
        }

        for(int i = 1; i < height; i++){
            for(int j = 1; j < width; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = getMin(dp,i,j)+1;
                    max = Math.max(dp[i][j],max);
                }

            }
        }
        return max*max;
    }

    public int getMin(int[][] dp, int i, int j){
        int min = Math.min(dp[i][j-1],dp[i-1][j]);
        min = Math.min(min,dp[i-1][j-1]);
        return min;
    }
}
