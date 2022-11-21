package LC_Code;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }
        int[] degree = new int[n];

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(i,new ArrayList<Integer>());
        }


        for(int i = 0; i < edges.length; i++){
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 1){
                queue.add(i);
            }
        }


        while(!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                res.add(cur);

                ArrayList<Integer> temp = map.get(cur);

                for(Integer j : temp){
                    degree[j]--;
                    if(degree[j] == 1){
                        queue.add(j);
                    }
                }
            }

        }
        return res;
    }
}
