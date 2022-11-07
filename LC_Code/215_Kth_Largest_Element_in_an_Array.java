class Solution {
    public int findKthLargest(int[] nums, int k) {

        heapInsert(nums);

        for(int i = 0; i < k; i++){
            swap(nums,0,nums.length-1-i);
            heapify(nums,nums.length-2-i);
        }

        return nums[nums.length-k];

    }

    public void heapInsert(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int father = (i-1)/2;
            int son = i;
            while(father >= 0 && nums[son] > nums[father]){
                swap(nums,father,son);
                son = father;
                father = (father-1)/2;
            }
        }
    }

    public void heapify(int[] nums, int size){
        if(size < 0){
            return;
        }
        int father = 0;
        int left = father*2+1;
        int right = father*2+2;
        while(left <= size){
            int largest = right <= size && nums[right] > nums[left] ? right : left;
            largest = nums[largest] > nums[father] ? largest : father;
            if(largest == father){
                break;
            }
            swap(nums,largest,father);
            father = largest;
            left = father*2+1;
            right = father*2+2;
        }
    }


    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
