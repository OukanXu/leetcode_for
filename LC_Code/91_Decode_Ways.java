class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];

        dp[0] = 1;

        for(int i = 1; i <= s.length(); i++){

            if(s.charAt(i-1)-'0' >=1 && s.charAt(i-1)-'0' <= 9){
                dp[i] += dp[i-1];
            }
            if(i > 1 && (s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0' >= 10 && (s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0' <= 26 && s.charAt(i-2) != '0'){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}


//round 2
class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n+1];

        dp[0] = 1;
        int index = 1;

        while(index <= n){
            

            
            int cur = s.charAt(index-1) - '0';
            

            if(cur >= 1 && cur <= 9){
                dp[index] += dp[index-1];
            }
            if(index > 1){
                int pre = s.charAt(index-2) - '0';
                int temp = pre*10 + cur;
                if(pre >= 1 && pre <= 2 && temp >= 10 && temp <= 26 && s.charAt(index-2) - '0' != 0){
                    dp[index] += dp[index-2];
                }
            }
            
            index++;
        }
        return dp[n];
    }
}
