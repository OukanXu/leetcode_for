public class test {
    public void sortColors(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int index = i;
            for(int j = i+1; j < nums.length; j++){
                
                if(nums[j] < nums[i]){
                    index = j;
                }
            }
            swap(nums, i, index);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main()
}
