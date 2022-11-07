class TwoSum {
    ArrayList<Integer> res;
    int count;
    boolean is_sorted;
    public TwoSum() {
        this.res = new ArrayList<Integer>();
        this.count = 0;
        this.is_sorted = false;
    }
    
    public void add(int number) {
        this.res.add(number);
        this.count++;
        this.is_sorted = false;
    }
    
    public boolean find(int value) {
        if(!is_sorted){
            Collections.sort(this.res);
            is_sorted = true;
        }
        
        int left = 0;
        int right = count-1;
        while(left < right){
            int temp = res.get(left)+res.get(right);
            if(temp < value){
                left++;
            }else if(temp > value){
                right--;
            }else if(temp == value){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */