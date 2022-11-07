class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        

        while(i < n){
            int count = 0;
            int sumGas = 0;
            int sumCost = 0;
            while(count < n){
                int j = (i+count)%n;
                sumGas += gas[j];
                sumCost += cost[j];

                if(sumCost > sumGas){
                    break;
                }
                count++;
            }

            if(count == n){
                return i;
            }else{
                i = i + count + 1;
            }
        }
        return -1;
    }
}