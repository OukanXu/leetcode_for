class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                max = max + prices[i] - minPrice;
                minPrice = prices[i];
            }
        }

        return max;
    }
}


//round 2
class Solution {
    public int maxProfit(int[] prices) {
        int benefit = 0;

        for(int i = 0; i < prices.length-1; i++){
            if(prices[i] < prices[i+1]){
                benefit += prices[i+1]-prices[i];
            }
        }
        return benefit;
    }
}
