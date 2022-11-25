//暴力递归，超时
class Solution {
    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {

        int count = 0;;
        
        int value = 0;
        dfs(coins, amount, count, value, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void dfs(int[] coins, int amount, int count, int value, int index){
        if(value == amount){
            min = Math.min(min,count);
            return;
        }

        if(value > amount){
            return;
        }

        for(int i = index; i < coins.length; i++){
            value += coins[i];
            count += 1;
            dfs(coins,amount,count,value,i);
            value -= coins[i];
            count -= 1;
        }
    }
}


//记忆化搜索，保留之前已经计算过的值
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] remember = new int[amount+1];
        return dfs(coins,amount,remember);
    }

    public int dfs(int[] coins, int amount, int[] remember){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }

        if(remember[amount] != 0){
            return remember[amount];
        }

        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = dfs(coins,amount-coin,remember);
            if(res >= 0 && res < min){//相当于使用了Math.min()
                min = res+1;
            }
        }
        remember[amount] = (min == Integer.MAX_VALUE) ? -1 : min;

        return remember[amount];
    }
}



//动态规划，实际与记忆化搜索类似
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int i = 0; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if( i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
