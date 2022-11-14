package LC_Code;


// n*n
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1){
            return;
        }

        int left = 0;
        int right = left+1;

        while(left < nums.length){
            if(nums[left] == 0){
                for(int i = left+1; i <nums.length; i++){
                    if(nums[i] != 0){
                        swap(nums,left,i);
                        break;
                    }
                }
            }
            left++;
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
}



// n
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1){
            return;
        }

        int left = 0;
        int right = 0;

        while(right < nums.length){
            if(nums[right] != 0){
                nums[left] = nums[right];
                left++;
            }
            right++;

            
        }

        for(int i = left; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}