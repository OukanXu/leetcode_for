// dfs  out of time
class Solution {
    private int count = 0;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        
        int start = 0;
        int temp = 0;
        dfs(nums,target,start,temp);
        return count;
    }

    public void dfs(int[] nums, int target, int start, int temp){
        if(temp > target){
            return;
        }else if( temp == target){
            count++;
            return;
        }

        for(int i = start; i < nums.length; i++){
            temp += nums[i];
            dfs(nums, target, start, temp);
            temp -= nums[i];
        }
    }
}


//dp
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i = 0; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[j] <= i){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}