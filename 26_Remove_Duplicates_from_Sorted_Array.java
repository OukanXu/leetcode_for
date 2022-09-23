class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        int i = 0;
        int j = i+1;
        int sum = 1;

        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                swap(nums,i+1,j);
                i++;
                j++;
                sum++;
            }
        }
        return sum;
    }

    public void swap(int[] arr, int i, int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
