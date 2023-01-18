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


//round 2
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            max = Math.max(max,nums[i] + i);

            if(nums[i] == 0 && max == i && i != nums.length-1){
                return false;
            }
        }
        return true;
    }
}