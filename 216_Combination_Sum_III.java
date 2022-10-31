class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        for(int i = 1; i <= k; i++){
            sum = sum + i;
        }
        if(n < sum){
            return res;
        }

        List<Integer> temp = new ArrayList<>();

        dfs(res, temp, k, n, 1);
        return res;
        
    }

    public void dfs(List<List<Integer>> res, List<Integer> temp, int k, int n, int index){
        if(temp.size() == k && n == 0){
            res.add(new ArrayList<>(temp));
            return;
        }else if(temp.size() == k && n != 0){
            return;
        }else if(n == 0 && temp.size() != k){
            return;
        }

        for(int i = index; i <= 9; i++){
            temp.add(i);
            n = n-i;
            index = index+1;
            dfs(res,temp,k,n,index);
            n = n + i;
            temp.remove(temp.size()-1);
        }
        
    }
}