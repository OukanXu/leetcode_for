class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> res = new ArrayList<>();

        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res.add(newInterval);

        while(i < intervals.length && intervals[i][0] > newInterval[1]){
            res.add(intervals[i]);
            i++;
        }
       
        int[][] result = new int[res.size()][2];
       for(int j = 0; j < res.size(); j++){
           result[j] = res.get(j);
       }

       return result;
       


    }
}





//round 2
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();

        int i = 0;
        
            while(i < intervals.length && intervals[i][1] < newInterval[0]){
                res.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
            }

            while(i < intervals.length && intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            res.add(new int[]{newInterval[0], newInterval[1]});




            while(i < intervals.length && intervals[i][0] > newInterval[1]){
                res.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
            }

            
        
        return res.toArray(new int[res.size()][]);
        
    }
}