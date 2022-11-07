class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }else if(target < nums[left]){
                    left = mid+1;
                }else if(target >= nums[mid]){
                    left = mid+1;
                }
            }else{//nums[left] > nums[mid]
                if(target >= nums[left]){
                    right = mid-1;
                }else if(target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}
