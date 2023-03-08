class Solution {
    public int findMin(int[] nums) {


        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[left] > nums[right]){
                if(nums[mid] >= nums[left]){
                    left = mid+1;
                }else if(nums[mid] < nums[right]){
                    right = mid;
                }
            }else{
                right = mid-1;
            }
        }
        return nums[left];
    }
}


//round 2
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(nums[left] < nums[right]){
            return nums[left];
        }
        while(left < right){
            int mid = left + (right-left)/2;
            // left > right
            if(nums[mid] > nums[right]){
                left = mid+1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }
            
        }
        return nums[left];
    }
}