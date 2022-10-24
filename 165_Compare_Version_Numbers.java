class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();

        int i = 0;
        int j = 0;
        
        while(i < len1 || j < len2){
            int sum1 = 0;
            int sum2 = 0;
            for(; i < len1 && version1.charAt(i) != '.'; i++){
                sum1 = sum1*10 + (version1.charAt(i)-'0');
            }
            i++;
            for(; j < len2 && version2.charAt(j) != '.'; j++){ 
                sum2 = sum2*10 + (version2.charAt(j)-'0');
            }
            j++;
            
            if(sum1 != sum2){
                return sum1 > sum2 ? 1:-1;
            }
        }

        return 0;
        
    }
}


