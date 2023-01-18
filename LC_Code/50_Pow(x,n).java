class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}


//round 2    超时  每个myPow(x,n/2)算了两次，所以要用变量抽象出来
class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            return 1/myPow(x,-n);
        }

        if(n == 0){
            return 1.0;
        }

        return n%2 == 0 ? myPow(x,n/2)*myPow(x,n/2) : myPow(x,n/2)*myPow(x,n/2)*x;
    }
}


// 上面 myPow(x,-n) 会越界，如果光转换成long，调用mypow时会把long转换成int，会丢失精度，所以用一个函数抽出来计算
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        
        return N >= 0 ? process(x,N) : 1.0/process(x,-N);
    }

    public double process(double x, long N){
        if(N == 0){
            return 1.0;
        }

        double y = process(x,N/2);

        return N % 2 == 0 ? y*y : y*y*x;
    }
}
