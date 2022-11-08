package LC_Code;

class Solution {
    public int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            count += process(nums,target-nums[i],i+1);
        }

        return count;
    }

    public int process(int[] nums, int target, int start){
        
        int left = start;
        int right = nums.length-1;

        int sum = 0;
        while(left < right){
            if(nums[left]+nums[right] < target){
                sum += right-left;
                left++;
            }else{
                right--;
            }
        }
        return sum;
    }
}