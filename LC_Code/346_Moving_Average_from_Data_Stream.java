class MovingAverage {
    private Queue<Integer> queue;
    private int sum;
    private int count;
    private int max;
    public MovingAverage(int size) {
        sum = 0;
        max = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if(count < max){
            count++;
            queue.add(val);
            sum += val;
            return (double)sum/count;
        }else{
            int temp = queue.poll();
            sum -= temp;
            sum += val;
            queue.add(val);
            return (double)sum /count;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

class MovingAverage {
    private Queue<Integer> queue;
    private double sum;
    private int size;
    public MovingAverage(int size) {
        sum = 0;
        this.size = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if(queue.size() == size){
            sum -= queue.poll();
        }
        sum += val;
        queue.add(val);
        return sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */