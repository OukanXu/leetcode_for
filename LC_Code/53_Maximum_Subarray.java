class Solution {
    public int maxSubArray(int[] nums) {
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            if(dp[i - 1] + nums[i] >= 0){
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            } else{
                dp[i] = nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}



//round 2
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];

        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}