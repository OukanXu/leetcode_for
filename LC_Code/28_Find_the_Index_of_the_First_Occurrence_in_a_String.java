class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return -1;
        }

        
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getPreNext(str2);

        while(i1 < str1.length && i2 < str2.length){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if(next[i2] == -1){
                i1++;
            }else{
                i2 = next[i2];
            }
        }

        return i2 == str2.length ? i1-i2 : -1;

    }


    public int[] getPreNext(char[] str){
        if(str.length == 0){
            return new int[0];
        }
        if(str.length == 1){
            return new int[]{-1};
        }
        if(str.length == 2){
            return new int[]{-1,0};
        }

        int[] preNext = new int[str.length];

        preNext[0] = -1;
        preNext[1] = 0;
        int i = 2;//数组位置
        int cn = 0;

        while(i < preNext.length){
            if(str[i-1] == str[cn]){
                cn+=1;
                preNext[i] = cn;
                i++;
            }else if(cn > 0){
                cn = preNext[cn];
            }else{
                preNext[i] = 0;
                i++;
            }
        }
        return preNext;
    }
}



//round 2
class Solution {
    public int strStr(String haystack, String needle) {
        int[] preSum = getPre(needle);

        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = preSum[j-1];
            }

            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return i-j+1;
            }
        }
        return -1;
    }


    public int[] getPre(String str){
        int[] preSum = new int[str.length()+1];

        int j = 0;

        for(int i = 1; i < str.length(); i++){
            while(j > 0 && str.charAt(j) != str.charAt(i)){
                j = preSum[j-1];
            }

            if(str.charAt(j) == str.charAt(i)){
                j++;
            }
            preSum[i] = j;
        }
        return preSum;
    }
}