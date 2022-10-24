class Solution {
    public String convertToTitle(int columnNumber) {


        StringBuilder res = new StringBuilder();

        while(columnNumber > 0){
            columnNumber--;
            int remeder = columnNumber%26;
            res.append((char)((remeder+26)%26+'A'));
            columnNumber = columnNumber/26;
        }

        res.reverse();
        return res.toString();
    }

    
}
