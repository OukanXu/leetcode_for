package LC_Code;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return;
        }

        Arrays.sort(nums);

        if(n%2 == 0){
            int[] less = new int[n/2];
            int[] more = new int[n/2];

            for(int i = 0; i < less.length; i++){
                less[i] = nums[i];
            }
            int j = 0;
            for(int i = n/2; i < n; i++){
                more[j] = nums[i];
                j++;
            }

            int i = 0;
            while(i < n){
                nums[i] = less[i/2];
                i++;
                nums[i] = more[i/2];
                i++;
            }
        }else{
            int[] less = new int[n/2+1];
            int[] more = new int[n/2];

            for(int i = 0; i < less.length; i++){
                less[i] = nums[i];
            }
            int j = 0;
            for(int i = n/2+1; i < n; i++){
                more[j] = nums[i];
                j++;
            }

            int i = 0;
            while(i < n-1){
                nums[i] = less[i/2];
                i++;
                nums[i] = more[i/2];
                i++;
            }
            nums[i] = less[less.length-1];
        }
    }
}
