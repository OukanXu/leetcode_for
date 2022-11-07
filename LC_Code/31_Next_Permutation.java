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