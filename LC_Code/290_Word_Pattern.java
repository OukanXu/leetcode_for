package LC_Code;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, ArrayList<Integer>> map1 = new HashMap<>();
        HashMap<String, ArrayList<Integer>> map2 = new HashMap<>();

        String[] str = s.split(" ");

        if(str.length != pattern.length()){
            return false;
        }

        for(int i = 0; i < str.length; i++){
            if(!map1.containsKey(pattern.charAt(i))){
                ArrayList<Integer> res = new ArrayList<>();
                res.add(i);
                map1.put(pattern.charAt(i),res);
            }else{
                ArrayList<Integer> res = map1.get(pattern.charAt(i));
                res.add(i);
                map1.put(pattern.charAt(i),res);
            }

            if(!map2.containsKey(str[i])){
                ArrayList<Integer> res = new ArrayList<>();
                res.add(i);
                map2.put(str[i],res);
            }else{
                ArrayList<Integer> res = map2.get(str[i]);
                res.add(i);
                map2.put(str[i],res);
            }
        }

        for(int i = 0; i < str.length; i++){
            ArrayList<Integer> r1 = map1.get(pattern.charAt(i));
            ArrayList<Integer> r2 = map2.get(str[i]);
            if(!r1.equals(r2)){
                return false;
            }
        }
        return true;
    }
}
