/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
 var merge = function(intervals) {
    intervals.sort((a,b) => a[0]-b[0]);
    let res = [];

    for(let i = 0; i < intervals.length; i++){
        if(res.length == 0 || res[res.length-1][1] < intervals[i][0]){
            res.push([intervals[i][0],intervals[i][1]]);
        }else if(res[res.length-1][1] < intervals[i][1]){
            res[res.length-1][1] = intervals[i][1];
        }else{
            continue;
        }
    }
    return res;
    
};



//round 2
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        int i = 0;
        int n = intervals.length-1;

        ArrayList<int[]> res = new ArrayList<>();

        while(i <= n){
            if(i == 0 || intervals[i][0] > res.get(res.size()-1)[1]){
                res.add(intervals[i]);
                i++;
            }else if(intervals[i][0] <= res.get(res.size()-1)[1]){
                res.get(res.size()-1)[1] = Math.max(intervals[i][1],res.get(res.size()-1)[1]);
                i++;
            }

            
        }
        return res.toArray(new int[res.size()][]);
    }
}