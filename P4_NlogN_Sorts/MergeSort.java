package P4_NlogN_Sorts;

/*
 * 先将两侧排序，排完之后合并两个有序数组
 */


 public class MergeSort{

    public static void process(int[] arr, int L, int R){
        if(L==R){
            return;
        }
        int mid = L+((R-L)>>1);
        process(arr, L, mid);
        process(arr, mid+1, R);
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr, int L, int M, int R){
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        while(p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1<=M){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[L+i] = help[i];
        }
    }

    /*
     * 小和问题  [1,3,4,2,5]  1*4+2*3+4*1+2*1 = 16
     * 左右组合并时，相同大小先拷贝右组，要找严格大于左组的数
     */

     public static int smallSum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        return process_small(arr, 0, arr.length-1);
     }

     //在arr[L...R]既要排好序，也要求小和
     public static int process_small(int[] arr, int l, int r){
        if(l == r){
            return 0;
        }
        int mid = l+((r-l)>>1);
        return process_small(arr, l, mid) //左侧排序中产生小和的数量
                + process_small(arr, mid+1, r) //右侧排序中产生小和的数量
                + merge_samll(arr,l,mid,r); //合并的时候产生小和的数量

     }

     public static int merge_samll(int[] arr, int L, int m, int r){
        int[] help = new int[r-L+1];
        int i = 0;
        int p1 = L;
        int p2 = m+1;
        int res= 0; 

        while(p1 <= m && p2 <= r){
            res += arr[p1] < arr[p2] ? (r-p2+1)*arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];//相同大小先拷贝右组，要找严格大于左组的数
        }

        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[L+i] = help[i];
        }
        return res;
     }



     /*
      * 逆序对问题   如果右侧的数比左侧数小，就是一个逆序对，求出所有逆序对数量
      */
 }