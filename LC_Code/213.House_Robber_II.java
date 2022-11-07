class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int length = nums.length;
        int[] dp = new int[length];

        

        // 0-length-2 max = dp[length-2]
        dp[0]  = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
       for(int i = 2; i < length-1; i++){
           dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
       }

       int[] mp = new int[length];
       // 1- length-1 max = dp[length-1]
       mp[0] = 0;
       mp[1] = Math.max(0,nums[1]);

       for(int i = 2; i < length; i++){
           mp[i] = Math.max(mp[i-1],mp[i-2]+nums[i]);
       }

       return Math.max(dp[length-2],mp[length-1]);
    }
}
