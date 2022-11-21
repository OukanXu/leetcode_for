package LC_Code;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for(int secondStart = 1; secondStart < n-1; secondStart++){
            if(num.charAt(0) == '0' && secondStart != 1){
                break;
            }

            for(int secondEnd = secondStart; secondEnd < n-1; secondEnd++){
                if(num.charAt(secondStart) == '0' && secondStart != secondEnd){
                    break;
                }

                if(valid(secondStart,secondEnd,num)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valid(int secondStart, int secondEnd, String num){
        int n = num.length();
        int firstStart = 0;
        int firstEnd = secondStart-1;
        
        while(secondEnd <= n-1){
            String third = add(firstStart,firstEnd,secondStart,secondEnd,num);
            int thirdStart = secondEnd+1;
            int thirdEnd = secondEnd+third.length();

            if(thirdEnd >= n || !num.substring(thirdStart,thirdEnd+1).equals(third)){
                break;
            }

            if(thirdEnd == n-1){
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;

    }


    public String add(int firstStart,int firstEnd,int secondStart,int secondEnd,String num){
        StringBuilder sb = new StringBuilder();


        int cur = 0;
        int temp = 0;//进位;
        while(firstEnd >= firstStart || secondEnd >= secondStart){
            if(firstEnd >= firstStart){
                cur += num.charAt(firstEnd)-'0';
                firstEnd--;
            }

            if(secondEnd >= secondStart){
                cur += num.charAt(secondEnd)-'0';
                secondEnd--;
            }

            cur = cur + temp;
            temp = cur / 10;
            cur = cur % 10;
            sb.append(String.valueOf(cur));
            cur = 0;
        }

        if(temp != 0){
            sb.append(String.valueOf(1));
        }

        sb.reverse();
        return sb.toString();

    }
}
