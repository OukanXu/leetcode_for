class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0){
            return true;
        }
        //建立入度表  课：入度
        HashMap<Integer,Integer> inDegree = new HashMap<>();

        //建立先修、后修课程表  先修课：后修课
        HashMap<Integer,List<Integer>> preNextCourses = new HashMap<>();

        //初始化入度表，初始入度全为0
        for(int i = 0; i < numCourses; i++){
            inDegree.put(i,0);
        }

        for(int[] arr : prerequisites){
            int preCourse = arr[1];
            int nextCourse = arr[0];

            //更新入度表
            int newInDegree = inDegree.get(nextCourse)+1;
            inDegree.put(nextCourse,newInDegree);

            //更新先后课程表
            if(!preNextCourses.containsKey(preCourse)){
                preNextCourses.put(preCourse,new ArrayList<Integer>());
            }
            preNextCourses.get(preCourse).add(nextCourse);
        }


        //开始执行BFS
        Queue<Integer> list = new LinkedList<>();
        
        //将入度为0的节点压入队列
        for(Integer key : inDegree.keySet()){
            if(inDegree.get(key) == 0){
                list.add(key);
            }
        }

        while(!list.isEmpty()){
            int head = list.poll();//弹出一个节点

            if(!preNextCourses.containsKey(head)){
                continue;
            }
            List<Integer> nextC = preNextCourses.get(head);//找到这节课的后续课程
            
            //后续课程入度-1
            for(Integer k : nextC){
                inDegree.put(k,inDegree.get(k)-1);
                if(inDegree.get(k) == 0){
                    list.add(k);
                }
            }
            
            
            
        }

        //如果最后还存在入度>0的课程，说明无法完成
        for(Integer k : inDegree.keySet()){
            if(inDegree.get(k) != 0){
                return false;
            }
        }
        return true;
    }
}
