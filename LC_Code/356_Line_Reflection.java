//哈希表处理法
class Solution {

    
    public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet<>();

        int min = points[0][0];
        int max = points[0][0];

        for(int[] temp : points){
            set.add(temp[0] + "x" +temp[1]);

            if(temp[0] > max){
                max = temp[0];
            }else if(temp[0] < min){
                min = temp[0];
            }
        }

        int reflectLine = min+max;


        for(int[] n : points){

            if(!set.contains(reflectLine-n[0] + "x"+ n[1])){
                return false;
            }
        }
        return true;
    }
}


//排序+双指针处理法