package LC_Code;

class ValidWordAbbr {
    HashMap<String,ArrayList<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String str : dictionary){
            String abbr = toAbbr(str);
            if(!map.containsKey(abbr)){
                ArrayList<String> res = new ArrayList<>();
                res.add(str);
                map.put(abbr,res);
            }else{
                ArrayList<String> res = map.get(abbr);
                res.add(str);
                map.put(abbr,res);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String temp = toAbbr(word);
        if(!map.containsKey(temp)){
            return true;
        }else{
            ArrayList<String> res = map.get(temp);
            for(String s : res){
                if(!s.equals(word)){
                    return false;
                }
            }
            return true;
        }
    }

    public String toAbbr(String str){
        if(str.length() <= 2){
            return str;
        }

        return str.charAt(0) + Integer.toString(str.length()-2)+ str.charAt(str.length()-1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */