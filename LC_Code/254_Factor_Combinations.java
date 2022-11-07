package LC_Code;

class Solution {
    
    public List<List<Integer>> getFactors(int n) {

        return dfs(2,n);
    }

    public List<List<Integer>> dfs(int start, int n){
        if(n == 1){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = start; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(n/i);
                res.add(temp);
                List<List<Integer>> next = dfs(i,n/i);
                for(List<Integer> j : next){
                    j.add(i);
                    res.add(j);
                }
            }
            
        }
        return res;
    }
}