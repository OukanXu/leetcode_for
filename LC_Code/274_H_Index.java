package LC_Code;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int i = citations.length-1; 
        int j = 0;
        while(i >= 0 && citations[i] > j){
            j++;
            i--;
        }
        return j;
    }
}
