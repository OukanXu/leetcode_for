class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0){
            return res;
        }
        if(s.length() == 1){
            List<String> temp = new ArrayList<>();
            temp.add(s);
            res.add(temp);
            return res;
        }
        List<String> temp = new ArrayList<>();
        dfs(s,temp,0,s.length());
        return res;
    }

    public void dfs(String s, List<String> temp, int start, int end){
        if(start >= s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start+1; i <= end; i++){
            String subString = s.substring(start,i);
            if(check(subString,0,subString.length()-1)){
                temp.add(subString);
                dfs(s,temp,i,end);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean check(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}







//round 2
class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        List<String> temp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        int i = 0;
        dfs(s,dp,temp,res,i);
        return res;
    }

    public void dfs(String s, boolean dp[][], List<String> temp, List<List<String>> res, int index){
        if(index == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(check(s,dp,index,i)){
                temp.add(s.substring(index,i+1));
                dfs(s,dp,temp,res,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean check(String s,boolean dp[][] ,int i, int j){
        if(i >= j){
            dp[i][j] = true;
        }else if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = check(s,dp,i+1,j-1);
        }
        return dp[i][j];
    }
}