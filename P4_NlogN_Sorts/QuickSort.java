package P4_NlogN_Sorts;

public class QuickSort {
    /*
     * 荷兰国旗问题
     * 问题一：给定一个数组arr， 和一个数num， 请把小于等于num的数放左边，大于num的放右边，要求额外空间O(1),时间O(N)
     * 
     * 问题二：给定一个数组arr， 和一个数num， 请把小于num的数放左边，等于num的数放中间，大于num的放右边，要求额外空间O(1),时间O(N)
     * 
     * 
     *      快排1.0 最差O(n^2)
     * 一： 情况一：设置一个小于等于区间，若arr[i] <= num; [i]和 小于等于区间的下一位数交换， 小于等于区间向右扩一位，i++
     *      情况二： arr[i] > num; i++
     * 
     *      快排2.0 最差O(N^2)(有序数组时)  最好情况：num为数组中值
     * 二： 设置一个小于区间和大于区间
     *      情况一：若arr[i] < num; [i]和 小于区间的下一位数交换， 小于区间向右扩一位，i++
     *      情况二：若arr[i] > num; [j]和 大于区间的前一位数交换， 大于区间向左扩一位，i不变
     *      情况三： arr[i] = num; i++
     *      当i与大于区间相等时，停止
     * 
     *      快排3.0 数学期望为O(NlogN)
     *      以数组随机数作为num，在此情况下好情况和坏情况是概率事件
     */


     public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length-1);
     }

     //arr[L...R]排好序
     public static void quickSort(int[] arr, int L, int R){
        if(L < R){
            swap(arr,L + (int)(Math.random() * (R-L+1)));//等概率随机选择一个位置，与最右侧换
            int [] p = partition(arr, L, R);//该数组长度为2，是等于最后一位数的数的下标范围
            quickSort(arr, L, p[0]-1);//小于区域递归
            quickSort(arr, p[1]+1, R);//大于区域递归
        }
     }

     //处理arr[l...r]的函数
     //默认以arr[r]做划分， arr[r] -> p   <p   ==p   >p
     //返回等于区域(左边界，右边界)，所以返回一个长度为2的数组res，res[0], res[1]
     public static int[] partition(int[] arr, int L, int R){
        int less = L-1;//<区右边界
        int more = R; // >左边界
        while(L < more){
            if(arr[L] < arr[R]){
                swap(arr, ++less, L++);
            }else if(arr[L] > arr[R]){
                swap(arr, --more, L);
            }else{
                L++;
            }
        }
        swap(arr,more,R);
        return new int[] {less+1, more};
     }

}
