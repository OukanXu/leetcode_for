class Solution {
    public String intToRoman(int num) {
        if(num == 0){
            return "";
        }


        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        String res = "";
        int i = 0;
        while(i < nums.length){
            if(num >= nums[i]){
                num = num - nums[i];
                res+=str[i];
            }else{
                i++;
            }
        }
        return res;
    }
}