//常规解法，超时
class Solution {
    public int bulbSwitch(int n) {
        boolean[] array = new boolean[n+1];
        Arrays.fill(array,true);

        for(int i = 2; i <= n; i++){

            int j = i;
            while(j <= n){
                array[j] = !array[j];
                j+=i;
            }
        }

        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == true){
                count+=1;
            }
        }
        return count-1;

    }
}


class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}