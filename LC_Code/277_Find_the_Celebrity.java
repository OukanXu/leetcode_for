package LC_Code;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            int[] inDegree = new int[n];
            int[] outDegree = new int[n];
    
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i != j && knows(i,j)){
                        outDegree[i]++;
                        inDegree[j]++;
                    }
                }
            }
    
            for(int i = 0; i < n; i++){
                if(inDegree[i] == n-1 && outDegree[i] == 0){
                    return i;
                }
            }
            return -1;
        }
    }



    /*
     * 通过对res进行反复赋值，找到最后一个有人认识的人
     * 
     * 判断这个人是否认识别人或者所有人是否认识这个人
     * 
     */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            int res = 0;
            for(int i = 0; i < n; i++){
                if(knows(res,i)){
                    res = i;
                }
            }
    
            for(int i = 0; i < n; i++){
                if(i == res){
                    continue;
                }
    
                if(knows(res,i) || !knows(i,res)){
                    return -1;
                }
            }
            return res;
        }
    }
