class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        if(!word1.equals(word2)){
            int distant = Integer.MAX_VALUE;

            int w1 = -1;
            int w2 = -1;

            for(int i = 0; i < wordsDict.length; i++){
                if(wordsDict[i].equals(word1)){
                    w1 = i;
                }
                if(wordsDict[i].equals(word2)){
                    w2 = i;
                }

                if(w1 != -1 && w2 != -1){
                    distant = Math.min(distant,Math.abs(w1-w2));
                }
            }
            return distant;
        }else{
            int distant = Integer.MAX_VALUE;

            ArrayList<Integer> res = new ArrayList<>();
            for(int i = 0; i < wordsDict.length; i++){
                if(wordsDict[i].equals(word2)){
                    res.add(i);
                }
            }

            for(int i = 1; i < res.size(); i++){
                distant = Math.min(distant,res.get(i)-res.get(i-1));
            }
            return distant;
        }
    }
}
