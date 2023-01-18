/**
 * @param {string[]} strs
 * @return {string[][]}
 */
//通过建立哈希表进行
 var groupAnagrams = function(strs) {
    const map = new Map();
    for(let str of strs){
        let arr = str.split("");
        arr.sort();
        let newStr = arr.toString();

        let list = map.get(newStr) ? map.get(newStr) : new Array();
        list.push(str); 
        map.set(newStr,list);
    }
    return Array.from(map.values());
};


//round 2
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sorted = String.copyValueOf(temp);
            List<String> list =  map.getOrDefault(sorted, new ArrayList<>());
            list.add(str);
            map.put(sorted,list);
        }

        List<List<String>> res = new ArrayList<>();

        for(String key : map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }
}