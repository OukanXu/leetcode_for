class WordDistance {
    HashMap<String,List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();

        for(int i = 0; i < wordsDict.length; i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i],new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int distant = Integer.MAX_VALUE;

        List<Integer> L1 = map.get(word1);
        List<Integer> L2 = map.get(word2);

        for(int i : L1){
            for(int j : L2){
                distant = Math.min(distant,Math.abs(i-j));
            }
        }
        
        return distant;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
