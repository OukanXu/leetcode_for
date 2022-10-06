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
