package LC_Code;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
            }
            
        }
        return max;
    }
}


class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > res.get(res.size()-1)){
                res.add(nums[i]);
            }else{
                int j = getIndex(res,nums[i]);
                res.set(j,nums[i]);
            }
        }
        return res.size();
    }

    public int getIndex(ArrayList<Integer> res, int target){
        int left = 0;
        int right = res.size()-1;

        while(left < right){
            int mid = left + (right-left)/2;

            if(res.get(mid) >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}


