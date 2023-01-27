class Solution {
    HashMap<Integer,Integer> visited = new HashMap<>();
    public int numTrees(int n) {
        if(n == 0){
            return 0;
        }

        return countSum(1,n);
    }

    public int countSum(int start, int end){
        if(start > end){
            return 1;
        }
        if(start == end){
            return 1;
        }

        if(visited.containsKey(end-start+1)){
            return visited.get(end-start+1);
        }
        int totalSum = 0;
        for(int i = start; i <= end; i++){
            
            int numOfLeft = countSum(start,i-1);
            int numOfRight = countSum(i+1,end);

            totalSum+=(numOfLeft*numOfRight);
        }
        visited.put(end-start+1,totalSum);
        return totalSum;
    }
}


//round 2
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int numTrees(int n) {
        return dfs(1,n);
    }

    public int dfs(int start, int end){
        if(start > end){
            return 1;
        }

        int res = 0;
        for(int i = start; i <= end; i++){
            int leftType = 0;
            int rightType = 0;
            if(map.containsKey(i-1-start+1)){
                leftType = map.get(i-1-start+1);
            }else{
                leftType = dfs(start,i-1);
                map.put(i-1-start+1,leftType);
            }
            

            if(map.containsKey(end-i-1+1)){
                rightType = map.get(end-i-1+1);
            }else{
                rightType = dfs(i+1,end);
                map.put(end-i-1+1,rightType);
            }
            
            res += leftType*rightType; 
        }
        return res;
    }
}