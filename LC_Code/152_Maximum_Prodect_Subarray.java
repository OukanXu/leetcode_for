class Solution {
    public int maxProduct(int[] nums) {

        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max*nums[i],nums[i]);
            min = Math.min(min*nums[i],nums[i]);
            res = Math.max(max,res);
        }

        return res;
    }

    
}


//roudn2
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int max = 1;
        int min = 1;
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i],nums[i]*max);
            min = Math.min(nums[i],nums[i]*min);
            res = Math.max(max,res);
        }
        return res;
    }
}