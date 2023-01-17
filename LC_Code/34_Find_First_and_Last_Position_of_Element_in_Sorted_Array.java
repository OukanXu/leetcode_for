class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }

        int left = 0;
        int right = nums.length-1;

        int center = -1;
        int start = -1;
        int end = -1;
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
        if(center == -1){
            return new int[]{start,end};
        }

        for(int i = center; i >= 0; i--){
            if(nums[i] == target){
                start = i;
            }else{
                break;
            }
        }

        for(int i = center; i < nums.length; i++){
            if(nums[i] == target){
                end = i;
            }else{
                break;
            }
        }

        return new int[]{start,end};
    }
}


//round 2
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;

            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] == target){
                left = mid;
                break;
            }
        }

        if(nums[left] != target){
            return new int[]{-1,-1};
        }

        
        int i = left, j = left;

        while(i >= 0 && nums[i] == target){
            i--;
        }
        while(j < nums.length && nums[j] == target){
            j++;
        }
        return new int[]{i+1,j-1};
    }
}