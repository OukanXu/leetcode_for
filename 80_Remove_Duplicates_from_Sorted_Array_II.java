class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 2;
        int right = 2;
        while(right < nums.length){
            if(nums[left-2] != nums[right]){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    
}