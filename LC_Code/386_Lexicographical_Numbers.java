class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();

        int index = 1;
        int number = 1;
        while(index <= n){
            list.add(number);
            if(number * 10 <= n){
                number *= 10;
            }else{
                while(number % 10 == 9 || number +1 > n){
                    number /= 10;
                }
                number++;
            }
            index++;
        }
        return list;
    }
}