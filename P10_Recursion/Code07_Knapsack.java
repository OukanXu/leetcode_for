package P10_Recursion;

public class Code07_Knapsack {
    
    //来到i位置时的决定
    public static int process1(int[] weights,int[] values,int i, int alreadyweight, int bag){
        if(alreadyweight > bag){
            return 0;
        }
        if(i == weights.length){
            return 0;
        }

        return Math.max(process1(weights,values,i+1,alreadyweight,bag),
                            values[i]+process1(weights, values, i, alreadyweight+weights[i], bag));
                        
    }
}
