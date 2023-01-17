class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        int j = 0;
        for(; i >= 1; i--){
            if(nums[i-1] < nums[i]){
                Arrays.sort(nums,i,nums.length);
                for(j = i; j < nums.length; j++){
                    if(nums[j] > nums[i-1]){
                        swap(nums,i-1,j);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }





    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



//round 2
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;

        while(i-1 >= 0){
            if(nums[i-1] < nums[i]){
                Arrays.sort(nums,i,nums.length);
                for(int j = i; j < nums.length; j++){
                    if(nums[i-1] < nums[j]){
                        swap(nums,i-1,j);
                        return;
                    }
                }
            }
            i--;
        }
        Arrays.sort(nums);
        return;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}




class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;

        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i >= 0){
            int j = nums.length-1;
            while(j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        int left = i+1;
        int right = nums.length-1;
        while(left <= right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}