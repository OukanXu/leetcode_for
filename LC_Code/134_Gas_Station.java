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


//round 2
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while(i < n){
            int step = 0;
            int tempGas = 0;
            int tempCost = 0;
            while(step < n){
                int j = (i+step)%n;
                tempGas += gas[j];
                tempCost += cost[j];

                if(tempCost > tempGas){
                    break;
                }
                step++;
            }
            if(step == n){
                return i;
            }else{
                i = i + step +1;
            }
        }
        return -1;
    }
}


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        int temp = 0;
        for(int i = 0; i < gas.length; i++){
            temp += gas[i] - cost[i];
            if(temp < min){
                min = temp;
                minIndex = i;
            }
        }
        return temp < 0 ? -1 : (minIndex+1)%gas.length;
    }
}