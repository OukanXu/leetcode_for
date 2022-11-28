class Solution {
    public boolean isValidSerialization(String preorder) {
        int i = 0;
        int slot = 1;
        int n = preorder.length();

        while(i < n){
            if(slot == 0){
                return false;
            }

            if(preorder.charAt(i) == ','){
                i++;
            }else if(preorder.charAt(i) == '#'){
                slot--;
                i++;
            }else{
                while(i < n && preorder.charAt(i) != ','){
                    i++;
                }
                slot++;
            }
        }
        return slot == 0;
    }
}
