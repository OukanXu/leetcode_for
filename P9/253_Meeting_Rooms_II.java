package P9;

class Solution {
    public int minMeetingRooms(int[][] intervals) {

        PriorityQueue<int[]> heap = new PriorityQueue<>(intervals.length, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });

        heap.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(heap.peek()[1] > intervals[i][0]){
                heap.offer(intervals[i]);
            }else{
                heap.poll();
                heap.offer(intervals[i]);
            }
        }
        return heap.size();
    }
}
