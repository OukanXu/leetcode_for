class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        //将每个字符串序列化，看成26进制的数，建立哈希表

        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : strings){
            StringBuilder st = new StringBuilder();
            for(int i = 0; i < str.length(); i++){
                st.append("#");
                st.append((str.charAt(i)-str.charAt(0)+26)%26);
            }
            String newStr = st.toString();
            if(!map.containsKey(newStr)){
                map.put(newStr,new ArrayList<String>());
            }
            map.get(newStr).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for(String str : map.keySet()){
            res.add(map.get(str));
        }
        return res;
    }
}
