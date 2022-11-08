package LC_Code;

class Solution {

    //sum&(-sum)可以获得最低的非0位
    public int[] singleNumber(int[] nums) {
        int sum = 0;

        for(Integer num : nums){
            sum^=num;
        }

        int res1 = 0;
        int res2 = 0;

        int firstOne = sum&(-sum);

        for(int i : nums){
            if((i&firstOne) == 0){
                res1^=i;
            }else{
                res2^=i;
            }
        }

        return new int[]{res1,res2};
    }
}
