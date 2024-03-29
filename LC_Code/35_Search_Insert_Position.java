class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }

        int left = 0;
        int right = nums.length-1;
        int center = -1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                center = mid;
                break;
            }

            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        if(center != -1){
            return center;
        }else{
            return left;
        }
    }
}


//round 2
class Solution {
    public int searchInsert(int[] nums, int target) {

        if(target > nums[nums.length-1]){
            return nums.length;
        }else if(target < nums[0]){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;

            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid;
            }else if(nums[mid] == target){
                return mid;
            }
        }
        return left;
    }
}