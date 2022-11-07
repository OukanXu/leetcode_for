class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        char[] chara = expression.toCharArray();

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < chara.length; i++){
            char temp = chara[i];
            if(!Character.isDigit(temp)){
                List<Integer> leftSet = diffWaysToCompute(expression.substring(0,i));
                List<Integer> rightSet = diffWaysToCompute(expression.substring(i+1));
                for(int l : leftSet){
                    for(int r : rightSet){
                        if(temp == '+'){
                            res.add(l+r);
                        }else if(temp == '-'){
                            res.add(l-r);
                        }else if(temp == '*'){
                            res.add(l*r);
                        }
                    }
                }
            }
        }

        if(res.isEmpty()){
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
}