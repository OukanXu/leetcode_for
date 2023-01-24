class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {


        
        
        process(n,k,1);
        return res;
    }

    public void process(int n, int k, int index){
        if(temp.size() == k){
            res.add(new ArrayList(temp));
            return;
        }

        for(int i = index; i <= n-k+1+temp.size(); i++){
            temp.add(i);
            process(n,k,i+1);
            temp.remove(temp.size()-1);
            
        }
    }
}


//round 2  35.56%
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int index = 1;
        dfs(n,k,index,temp,res);
        return res;
    }

    public void dfs(int n, int k, int index, List<Integer> temp, List<List<Integer>> res){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i <= n; i++){
            temp.add(i);
            dfs(n,k,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }
}




//优化 99.99%
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int index = 1;
        dfs(n,k,index,temp,res);
        return res;
    }

    public void dfs(int n, int k, int index, List<Integer> temp, List<List<Integer>> res){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i <= n - (k-temp.size())+1; i++){// 剪枝
            temp.add(i);
            dfs(n,k,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }
}
