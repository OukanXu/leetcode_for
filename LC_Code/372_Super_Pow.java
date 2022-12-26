
class Solution {
    public int superPow(int a, int[] b) {
        int mod = 1337;
        int res = 1;

        for(int i = b.length-1; i >= 0; i--){
            res =(int) ((long)res * pow(a,b[i]) % mod);
            a = pow(a,10);
        }
        return res;
    }

    public int pow(int a, int b){
        
        int res = 1;
        while(b != 0){
            if(b % 2 != 0){
                res =(int) ((long)res * a% 1337);
            }
            a =(int) ((long)a*a % 1337);
            b /= 2;
        }
        return res;
    }
}