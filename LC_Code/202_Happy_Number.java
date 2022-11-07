class Solution {
    public boolean isHappy(int n) {
        String temp = String.valueOf(n);

        HashSet<String> map = new HashSet<>();

        while(!temp.equals("1")){
            int Onetime = 0;
            for(int i = 0; i < temp.length();i++){
                Onetime += Math.pow((int)(temp.charAt(i)-'0'),2);
            }
            temp = String.valueOf(Onetime);
            if(map.contains(temp)){
                return false;
            }
            map.add(temp);
        }
        return true;

    }
}
