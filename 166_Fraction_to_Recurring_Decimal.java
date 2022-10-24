class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        if(a%b == 0){
            return String.valueOf(a/b);
        }

        StringBuilder res = new StringBuilder();
        if(a*b < 0){
            res.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        res.append(String.valueOf(a/b));
        res.append(".");
        a = a%b;

        HashMap<Long,Integer> map = new HashMap<>();

        while(a != 0){
            map.put(a,res.length());
            a = a*10;
            res.append(a/b);
            a = a%b;

            if(map.containsKey(a)){
                int index = map.get(a);
                return String.format("%s(%s)",res.substring(0,index),res.substring(index)); 
            }
        }
        return res.toString();
    }
}