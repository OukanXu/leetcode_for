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
