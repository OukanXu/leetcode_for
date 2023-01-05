class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++){
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }

        for(int i = 0; i < ransomNote.length(); i++){
            if(!map.containsKey(ransomNote.charAt(i))){
                return false;
            }
            map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
            if(map.get(ransomNote.charAt(i))==0){
                map.remove(ransomNote.charAt(i));
            }
        }
        return true;
    } 
}




class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            arr[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++){
            arr[ransomNote.charAt(i) - 'a']--;
            if(arr[ransomNote.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}