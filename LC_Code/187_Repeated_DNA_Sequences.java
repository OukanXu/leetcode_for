class Solution {
    public List<String> findRepeatedDnaSequences(String s) {


        int len = 10;

        HashMap<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(int i = 0; i <= s.length()-len; i++){
            String temp = s.substring(i,i+len);
            if(!map.containsKey(temp)){
                map.put(temp,1);
            }else{
                map.put(temp,map.get(temp)+1);
            }
            
            if(map.get(temp) == 2){
                res.add(temp);
            }
        }
        return res;
    }
}
