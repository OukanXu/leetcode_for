
class HitCounter {
    private Deque<Integer> queue;
    private int count;
    public HitCounter() {
        queue = new LinkedList<>();
        count = 0;
    }
    
    public void hit(int timestamp) {
        queue.add(timestamp);
        count++;
    }
    
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && queue.peek() <= timestamp-300){
            queue.poll();
            count--;
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */