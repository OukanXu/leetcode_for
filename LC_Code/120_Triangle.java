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


//round 2
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < triangle.size(); i++){
            min = Math.min(min,dp[triangle.size()-1][i]);
        }
        return min;
    }
}

// 自底向上，速度更快
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j); 
            }
        }
        return dp[0];
    }
}