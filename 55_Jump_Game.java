class Solution {
    public boolean canJump(int[] nums) {
        int maxRight = 0;

        for(int i = 0; i < nums.length; i++){
            maxRight = Math.max(maxRight,i+nums[i]);
            if(nums[i] == 0 && i == maxRight &&maxRight < nums.length-1){
                return false;
            }
        }
        return true;
    }
}
