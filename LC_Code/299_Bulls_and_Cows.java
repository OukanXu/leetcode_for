package LC_Code;

class Solution {
    public String getHint(String secret, String guess) {
        int x = 0;
        int y = 0;

        HashMap<Character,ArrayList<Integer>> map1 = new HashMap<>();
        HashMap<Character,ArrayList<Integer>> map2 = new HashMap<>();

        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                x++;
            }else{
                if(!map1.containsKey(secret.charAt(i))){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map1.put(secret.charAt(i),temp);
                }else{
                    ArrayList<Integer> temp = map1.get(secret.charAt(i));
                    temp.add(i);
                    map1.put(secret.charAt(i),temp);
                }

                if(!map2.containsKey(guess.charAt(i))){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map2.put(guess.charAt(i),temp);
                }else{
                    ArrayList<Integer> temp = map2.get(guess.charAt(i));
                    temp.add(i);
                    map2.put(guess.charAt(i),temp);
                }
            }
        }

        for(char ch : map1.keySet()){
            if(!map2.containsKey(ch)){
                continue;
            }
            ArrayList<Integer> temp1 = map1.get(ch);
            ArrayList<Integer> temp2 = map2.get(ch);

            y += (temp1.size() < temp2.size() ? temp1.size() : temp2.size());
        }

        return Integer.toString(x) + "A" + Integer.toString(y) + "B";
    }
}




class Solution {
    public String getHint(String secret, String guess) {
        int x = 0;
        int y = 0;

        int[] sArr = new int[10];
        int[] gArr = new int[10];
        for(int i = 0; i < secret.length(); i++){
            int temp1 = secret.charAt(i)-'0';
            int temp2 = guess.charAt(i)-'0';

            if(temp1 == temp2){
                x++;
            }else{
                sArr[temp1]++;
                gArr[temp2]++;
            }
        }

        for(int i = 0; i < 10; i++){
            y += Math.min(sArr[i],gArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(x));
        sb.append("A");
        sb.append(Integer.toString(y));
        sb.append("B");
        return sb.toString();
    }
}
