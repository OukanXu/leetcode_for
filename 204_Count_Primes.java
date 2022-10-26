class Solution {
    public int countPrimes(int n) {
        int count = 0;
        if(n <=2){
            return count;
        }

        for(int i = 2; i < n; i++){
            count+= isPrime(i) ? 1:0;
        }
        return count;
    }

    public boolean isPrime(int i){

        for(int x = 2; x*x <= i; x++){
            if(i % x == 0){
                return false;
            }
        }
        return true;
    }
}
