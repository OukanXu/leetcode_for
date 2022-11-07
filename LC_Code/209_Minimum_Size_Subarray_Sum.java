class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int temp = nums[0];

        while(left < nums.length && right < nums.length && left <= right){
            if(temp < target){
                
                right++;
                if(right > nums.length-1){
                    break;
                }
                temp = temp + nums[right];
            }else if(temp >= target){

                int newLen = right-left+1;
                len = Math.min(len,newLen);
                temp = temp - nums[left];
                left++;
            }
        }

        if(len == Integer.MAX_VALUE){
            len = 0;
        }
        return len;
    }
}
