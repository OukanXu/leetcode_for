class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];

        int maxSize = 0;
        int maxValue = 0;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i] > maxSize){
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }

        List<Integer> res = new ArrayList<>();

        if(maxSize == 1){
            res.add(nums[0]);
            return res;
        }

        for(int i = n-1; i >= 0; i--){
            if(maxValue % nums[i] == 0 && maxSize > 0 && dp[i] == maxSize){
                maxValue = nums[i];
                maxSize--;
                res.add(nums[i]);
            }
        }
        return res;
    }
}
