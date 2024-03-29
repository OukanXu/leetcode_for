package LC_Code;

class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 1; i <= nums.length; i++){
            res ^= i;
        }

        for(int i = 0; i < nums.length; i++){
            res ^= nums[i];
        }

        return res;
    }
}
