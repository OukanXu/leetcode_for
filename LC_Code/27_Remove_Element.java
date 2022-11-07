class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length-1;
        int sum = 0;
        while(j >= i){
            if(nums[i] == val){
                swap(nums,i,j);
                j--;
            }else{
                i++;
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
