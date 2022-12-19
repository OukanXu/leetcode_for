class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity + jug2Capacity < targetCapacity){
            return false;
        }
        int n = gcd(jug1Capacity,jug2Capacity);
        return targetCapacity % n == 0;
    }

    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
}
