class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> answer = new ArrayList<>();

        //初始条件判断
        if(numCourses < 1){
            return new int[0];
        }

        if(prerequisites == null || prerequisites.length == 0){
            int[] ans = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                ans[i] = i;
            }
            return ans;
        }



        //建议入度表  课：入度
        HashMap<Integer,Integer> inDegree = new HashMap<>();

        //建立先后课程表  先修课：后修课
        HashMap<Integer,List<Integer>> preNextCourses = new HashMap<>();

        //初始化入度表 初始入度全为0
        for(int i = 0; i < numCourses; i++){
            inDegree.put(i,0);
        }

        //初始化先后课程表并更新入度表
        for(int[] arr : prerequisites){
            int preCourse = arr[1];
            int nextCourse = arr[0];

            //next课的入度+1
            inDegree.put(nextCourse,inDegree.get(nextCourse)+1);

            //如果在先后课程表中该节点不存在，就创建
            if(!preNextCourses.containsKey(preCourse)){
                preNextCourses.put(preCourse,new ArrayList<>());
            }

            preNextCourses.get(preCourse).add(nextCourse);
        }


        //准备开始BFS

        Queue<Integer> list = new LinkedList<>();

        //初始化队列,将入度为0的节点加入队列
        for(Integer k : inDegree.keySet()){
            if(inDegree.get(k) == 0){
                list.add(k);
            }
        }

        while(!list.isEmpty()){
            int head = list.poll();

            //初始条件判断，一开始入度为0的节点一定不会在 先后课程表中，但是也要加入答案中
            if(!preNextCourses.containsKey(head)){
                answer.add(head);
                continue;
            }

            answer.add(head);
            //找到该节点的后续课程
            List<Integer> nextOnes = preNextCourses.get(head);

            //后续课程遍历，每个后续课程入度-1
            for(Integer k : nextOnes){
                inDegree.put(k,inDegree.get(k)-1);
                if(inDegree.get(k) == 0){
                    list.add(k);
                }
            }
        }

        //如果队列为空，但是入度表中还存在入度 ！= 0 的节点，说明无法进行全部课程
        for(Integer k : inDegree.keySet()){
            if(inDegree.get(k) != 0){
                return new int[0];
            }
        }

        int[] ans = new int[answer.size()];

        //将ArrayList转化为array
        for(int i = 0; i < ans.length; i++){
            ans[i] = answer.get(i);
        }

        return ans;



    }
}