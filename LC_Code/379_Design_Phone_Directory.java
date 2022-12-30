class PhoneDirectory {
    public boolean[] temp;
    public int count;
    public PhoneDirectory(int maxNumbers) {
        temp = new boolean[maxNumbers];
        count = maxNumbers;
        Arrays.fill(temp,true);
    }
    
    public int get() {
        if(count == 0){
            return -1;
        }

        for(int i = 0; i < temp.length; i++){
            if(temp[i] == true){
                temp[i] = false;
                return i;
            }
        }
        return -1;
    }
    
    public boolean check(int number) {
        return temp[number];
    }
    
    public void release(int number) {
        temp[number] = true;
        count++;
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
