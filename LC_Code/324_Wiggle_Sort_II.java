class Solution {
    public void wiggleSort(int[] nums) {
        int[] clone  = nums.clone();
        Arrays.sort(clone);

        int left = (nums.length-1)/2;
        int right = nums.length-1;

        for(int i = 0; i < nums.length; i++){
            if(i %2 == 1){
                nums[i] = clone[right];
                right--;
            }else{
                nums[i] = clone[left];
                left--;
            }
            
        }
        
    }
}