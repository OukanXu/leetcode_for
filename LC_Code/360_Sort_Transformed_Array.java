class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;

        int[] res = new int[n];

        if(a > 0){
            int left = 0;
            int right = n-1;
            int index = n-1;
            
            while(left <= right){
                int tempLeft = count(a,b,c,nums[left]);
                int tempRight = count(a,b,c,nums[right]);
                if(tempLeft > tempRight){
                    res[index] = tempLeft;
                    index--;
                    left++;
                }else{
                    res[index] = tempRight;
                    index--;
                    right--;
                }
            }
        }else if(a == 0){
            if(b > 0){
                int index = 0;
                while(index < n){
                    res[index] = count(a,b,c,nums[index]);
                    index++;
                }
            }else{
                int index = n-1;
                int i = 0;
                while(index >= 0 && i < n){
                    res[index] = count(a,b,c,nums[i]);
                    index--;
                    i++;
                }
            }
        }else{
            int left = 0;
            int right = n-1;
            int index = 0;
            while(left <= right){
                int tempLeft = count(a,b,c,nums[left]);
                int tempRight = count(a,b,c,nums[right]);
                if(tempLeft > tempRight){
                    res[index] = tempRight;
                    index++;
                    right--;
                }else{
                    res[index] = tempLeft;
                    index++;
                    left++;
                }
            }
        }
        return res;

    }

    public int count(int a, int b, int c, int x){
        return a*x*x+b*x+c;
    }
}