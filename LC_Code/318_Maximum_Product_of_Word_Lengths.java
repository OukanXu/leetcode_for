class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int length = words.length;
        int[] array = new int[length];

        for(int i = 0; i < length; i++){
            String s = words[i];

            int num = 0;
            int len = s.length();
            for(int j = 0; j < len; j++){
                num |= (1 << (s.charAt(j)-'a'));
            }
            array[i] = num;
        }

        for(int i = 0; i < length; i++){
            for(int j = i+1; j < length; j++){
                if((array[i]&array[j]) == 0){
                    max = Math.max(words[i].length()*words[j].length(),max);
                }
            }
        }
        return max;
    }
}
