class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n+1];
        int m = primes.length;
        int[] points = new int[primes.length];
        int[] nums = new int[primes.length];
        Arrays.fill(nums,1);
        
        

        for(int i = 1; i <= n; i++){
            int minNum = Arrays.stream(nums).min().getAsInt();

            dp[i] = minNum;
            for(int j = 0; j < m; j++){
                if(nums[j] == minNum){
                    points[j]++;
                    nums[j] = primes[j] * dp[points[j]];
                    nums[j] = nums[j] > 0 ? nums[j] : Integer.MAX_VALUE;
                }
            }

        }
        return dp[n];

        
    }
}