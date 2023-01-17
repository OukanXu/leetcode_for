class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums[0] == 0 || (nums[0] == nums.length && nums.length == 1)){
            return 0;
        }
        int step = 0;
        int cur = 0; 
        while(cur + nums[cur] < nums.length-1){
            int max = 0;
            int next = 0;
            for(int i = cur; i <= cur + nums[cur]; i++){
                if(i + nums[i] > max){
                    max = i+nums[i];
                    next = i;
                }
            }
            cur = next;
            step++;
        }
        step++;
        return step;
    }
}


//round 2
class Solution {
    public int jump(int[] nums) {

        if(nums[0] == 0 || nums.length == 1){
            return 0;
        }
        int length = nums.length-1;

        int step = 1;
        int next = 0;
        int max = 0;
        int index = 0;
        while(index < length && index + nums[index] < length){
            for(int i = index; i <= index + nums[index]; i++){
                if(i + nums[i] > max){
                    max = i+nums[i];
                    next = i;
                }else{
                    continue;
                }
            }
            index = next;
            step++;
        }
        return step;
    }
}