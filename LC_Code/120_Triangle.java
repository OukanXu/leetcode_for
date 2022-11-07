class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {


        int row = triangle.size();
        int col = triangle.get(row-1).size();

        int[][] dp = new int[row+1][col+1];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < row; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(j > 0 && j < triangle.get(i-1).size()){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle.get(i).get(j);
                }else if(j > 0 && j == triangle.get(i-1).size()){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }
            }
        }

        
        

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++){
            if(dp[row-1][i] < min){
                min = dp[row-1][i];
            }
        }
        return min;
    }
}