package P9;

import java.util.Arrays;
import java.util.Comparator;

public class Code04_bestArrange {
    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public static class ProgramComparator implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2){
            return o1.end - o2.end;
        }
    }


    public static int bestArrange(Program[] programs, int timePoint){
        Arrays.sort(programs, new ProgramComparator());//按照会议结束时间从早到晚排序
        int result = 0;
        //遍历所有会议
        for(int i = 0; i < programs.length; i++){
            if(timePoint <= programs[i].start){
                result++;
                timePoint = programs[i].end;
            }
        }
        return result;
    }
}
