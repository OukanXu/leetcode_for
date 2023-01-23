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


//round 2
class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        int[] res = new int[digits.length+1];
        int carry = 0; 
        digits[i]++;
        while(i >= 0){
            digits[i] = digits[i]+carry;
            carry = digits[i]/10;
            digits[i] = digits[i] % 10;
            i--;
        }

        if(carry == 0){
            return digits;
        }

        res[0] = 1;
        for(i = 0; i < digits.length; i++){
            res[i+1] = digits[i];
        }

        return res;
    }
}