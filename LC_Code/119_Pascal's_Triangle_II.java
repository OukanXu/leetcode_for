class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            List<Integer> eachRow = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    eachRow.add(1);
                }else{
                    eachRow.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(eachRow);
        }
        return res.get(res.size()-1);
    }
}


//round 2
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);

        for(int i = 1; i <= rowIndex; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    temp.add(1);
                }else{
                    temp.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = temp;
        }
        return pre;
    }
}
