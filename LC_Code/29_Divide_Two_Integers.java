class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        int numOfNe = 2;
        if(dividend > 0){
            numOfNe--;
            dividend = -dividend;
        }

        if(divisor > 0){
            numOfNe--;
            divisor = -divisor;
        }

        int res = process(dividend,divisor);

        return numOfNe == 1 ? -res : res;
    }

    public int process(int dividend, int divisor){

        int res = 0;
        while(dividend <= divisor){
            int temp = divisor;
            int quo = 1;//商
            while(temp > (Integer.MIN_VALUE >> 1) && dividend <= temp + temp){
                temp = temp+temp;
                quo = quo+quo;
            }

            dividend = dividend-temp;
            res = res+quo;

        }
        return res;
    }
}



//round 2
class Solution {
    public int divide(int dividend, int divisor) {

        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        int flag = 1;
        if(dividend < 0){
            flag = -flag;
        }
        if(divisor < 0){
            flag = -flag;
        }

        int count = getdivide(-Math.abs(dividend),-Math.abs(divisor));

        return flag == 1 ? count : -count;


    }


    public int getdivide(int dividend, int divisor){
        if(dividend > divisor) return 0;
        int count = 1;
        int temp = divisor;
        while(temp + temp >= dividend && temp >= (Integer.MIN_VALUE>>1)){
            temp = temp<<1;
            count = count<<1;
        }

        return count + getdivide(dividend-temp, divisor);
    }
}