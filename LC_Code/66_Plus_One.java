class Solution {
    public int[] plusOne(int[] digits) {


        for(int i = digits.length-1; i>=0; i--){
            digits[i]++;
            digits[i] = digits[i]%10;
            if(digits[i]%10 != 0){
                return digits;
            }
        }
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        
        return newDigits;
    }
}
