//两次dfs
class Solution {
    private int max = 1;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int tempDeep = 1;
        dfs(nestedList,tempDeep);
        System.out.println(max);
        int deep = 1;
        int sum = countSum(nestedList,deep);
        return sum;
    }

    public void dfs(List<NestedInteger> nestedList,int tempDeep){
        if(nestedList.size() == 0){
            return;
        }
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                continue;
            }else{
                tempDeep++;
                dfs(ni.getList(),tempDeep);
                tempDeep--;
            }
        }
        max = Math.max(max,tempDeep);
    }

    public int countSum(List<NestedInteger> nestedList, int deep){
        if(nestedList == null){
            return 0;
        }
        int sum = 0;

        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                sum += ni.getInteger() * (max-deep+1);
            }else{
                sum += countSum(ni.getList(),deep+1);
            }
        }
        return sum;
    }
}


//一次dfs
class Solution {
    private int max = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int deep = 1;
        
        dfs(nestedList,map,deep);
        System.out.println(max);
        int res = 0;
        for(Integer i : map.keySet()){
            res += (max-i+1)*map.get(i);
        }
        return res;
    }

    public void dfs(List<NestedInteger> nestedList, HashMap<Integer,Integer> map, int deep){
        if(nestedList.isEmpty()){
            return;
        }
        max = Math.max(max,deep);
        int tempSum = 0;

        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                tempSum += ni.getInteger();
            }else{
                dfs(ni.getList(),map,deep+1);
            }
        }
        map.put(deep, map.getOrDefault(deep,0)+tempSum);
    }
}
