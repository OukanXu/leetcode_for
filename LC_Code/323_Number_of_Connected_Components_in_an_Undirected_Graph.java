class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Integer>> neighbor = new HashMap<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            neighbor.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            neighbor.get(edge[0]).add(edge[1]);
            neighbor.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                dfs(visited,i,neighbor);
            }
        }
        return count;
    }

    public void dfs(boolean[] visited, int index, HashMap<Integer,ArrayList<Integer>> neighbor){
        visited[index] = true;
        for(int i : neighbor.get(index)){
            if(!visited[i]){
                dfs(visited,i, neighbor);
            }
        }
    }

    
}