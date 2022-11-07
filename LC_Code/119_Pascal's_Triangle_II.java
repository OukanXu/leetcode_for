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
