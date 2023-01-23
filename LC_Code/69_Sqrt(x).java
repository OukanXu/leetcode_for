class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        long left = 0;
        long right = x;
        int index = -1;

        while(left <= right){
            long mid  = (left+right)/2;
            if(mid*mid <= x){
                index = (int)mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return index;
    }
}


//round 2
class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x==1){
            return x;
        }
        long left = 0;
        long right = x;

        int res = -1;
        long mid = 0;
        while(left < right){
            mid = left + (right-left)/2;
            if(mid * mid <= x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return (int)(left-1);
    }
}